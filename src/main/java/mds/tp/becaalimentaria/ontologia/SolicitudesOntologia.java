package mds.tp.becaalimentaria.ontologia;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.Binding;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.MalformedQueryException;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.UpdateExecutionException;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import mds.tp.becaalimentaria.util.UpdateUtil;


public class SolicitudesOntologia {
	
	private RepositoryConnection connection;

    public SolicitudesOntologia(RepositoryConnection connection) {
        this.connection = connection;
    }
    
    private String prefijoOnto = "PREFIX base: <http://www.semanticweb.org/bruno/ontologies/2021/5/untitled-ontology-4#>"; 
    
    public void listarSolicitudes() throws RepositoryException, MalformedQueryException, QueryEvaluationException {
    	 try {
             // Preparing a SELECT query for later evaluation
             TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,
             		prefijoOnto + "select ?idSolicitud ?Solicitud "
             				+ "{ ?Solicitud a base:Solicitud }"
                            );

             // Evaluating a prepared query returns an iterator-like object
             // that can be traversed with the methods hasNext() and next()
             TupleQueryResult tupleQueryResult = tupleQuery.evaluate();
             while (tupleQueryResult.hasNext()) {
                 // Each result is represented by a BindingSet, which corresponds to a result row
                 BindingSet bindingSet = tupleQueryResult.next();

                 // Each BindingSet contains one or more Bindings
                 for (Binding binding : bindingSet) {
                     // Each Binding contains the variable name and the value for this result row
                     String name = binding.getName();
                     Value value = binding.getValue();
             
                     System.out.println(name + " = " + value);
                 }

                 // Bindings can also be accessed explicitly by variable name
                 //Binding binding = bindingSet.getBinding("x");
             }

             // Once we are done with a particular result we need to close it
             tupleQueryResult.close();

             // Doing more with the same connection object
             // ...
         } finally {
             // It is best to close the connection in a finally block
             connection.close();
         }
        
}
    
    public void deleteSolicitud(String solicitud) throws RepositoryException {
        System.out.println("# Deleting " + solicitud);

        // When removing data we need to start a transaction
        connection.begin();

        // Removing a person means deleting all triples where the person is the subject or the object.
        // Alternatively, this can be done with SPARQL.
        connection.remove(uriForSolicitud(solicitud), null, null);
        connection.remove((IRI) null, null, uriForSolicitud(solicitud));

        // Committing the transaction persists the changes
        connection.commit();
    }
    
    
    public void addSolicitud(String solicitud, Integer cantidadHermanos, Double ingresoFamiliarTotal, Integer idSolicitud) throws MalformedQueryException, RepositoryException, UpdateExecutionException {

        IRI solicitudURI = uriForSolicitud(solicitud);
        int id = idSolicitud;
        System.out.println("la solicitud es" + solicitudURI);
        System.out.println("# Adding " + solicitud + " con id n° " + id);


        // When adding data we need to start a transaction
        connection.begin();

        // We interpolate the URIs inside the string as INSERT DATA may not contain variables (bindings)
        UpdateUtil.executeUpdate(connection,
                String.format(
                        "PREFIX base: <http://www.semanticweb.org/bruno/ontologies/2021/5/untitled-ontology-4#>" +
                                "INSERT DATA {" +
                                "<%s> base:idSolicitud " + id + "." +
                                "<%s> base:cantidadHermanos " + cantidadHermanos + "." +
                                "<%s> base:IngresoFamiliarTotal " + "\"" + ingresoFamiliarTotal + "\""+ "^^xsd:double" +"." +
                                "<%s> rdf:type base:Solicitud " + 
                                "}", solicitudURI,solicitudURI,solicitudURI,solicitudURI));

        // Committing the transaction persists the changes
        connection.commit();
    }
    
    
    
    
    private IRI uriForSolicitud(String solicitud) {
    	 return SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/bruno/ontologies/2021/5/untitled-ontology-4#" + solicitud);
    }
    
    
    /*public void addSolicitudConConexion(String solicitud, Integer cantidadHermanos, Double ingresoFamiliarTotal) throws MalformedQueryException, RepositoryException, UpdateExecutionException {

    	// Abstract representation of a remote repository accessible over HTTP
        HTTPRepository repository = new HTTPRepository("http://localhost:7200/repositories/tpOntologias");

        // Separate connection to a repository
        RepositoryConnection connection = repository.getConnection();

        
        // Clear the repository before we start
       // connection.clear();

        SolicitudesOntologia solicitudesOntologia = new SolicitudesOntologia(connection);

        System.out.println(" hola soy la ontologia");
        	
    	
        IRI solicitudURI = uriForSolicitud(solicitud);
        
        int id = 30;
        System.out.println("la solicitud es" + solicitudURI);
        System.out.println("# Adding " + solicitud + " con id n° " + id);


        // When adding data we need to start a transaction
        connection.begin();

        // We interpolate the URIs inside the string as INSERT DATA may not contain variables (bindings)
        UpdateUtil.executeUpdate(connection,
                String.format(
                        "PREFIX base: <http://www.semanticweb.org/bruno/ontologies/2021/5/untitled-ontology-4#>" +
                                "INSERT DATA {" +
                                "<%s> base:idSolicitud " + id + "." +
                                "<%s> base:cantidadHermanos " + cantidadHermanos + "." +
                                "<%s> base:IngresoFamiliarTotal " + "\"" + ingresoFamiliarTotal + "\""+ "^^xsd:double" +"." +
                                "<%s> rdf:type base:Solicitud " + 
                                "}", solicitudURI,solicitudURI,solicitudURI,solicitudURI));

        // Committing the transaction persists the changes
        connection.commit();
    }
    
    
        
    //el main method
    
   /* public static void main(String[] args) throws Exception {
        // Open connection to a new temporary repository
        // (in order to infer grandparents/grandchildren we need the OWL2-RL ruleset)
       // RepositoryConnection connection = EmbeddedGraphDB.openConnectionToTemporaryRepository("owl2-rl-optimized");

        // Alternative: connect to a remote repository

        // Abstract representation of a remote repository accessible over HTTP
        HTTPRepository repository = new HTTPRepository("http://localhost:7200/repositories/tpOntologias");

        // Separate connection to a repository
        RepositoryConnection connection = repository.getConnection();

        

        // Clear the repository before we start
       // connection.clear();

        SolicitudesOntologia solicitudesOntologia = new SolicitudesOntologia(connection);

        try {
        	//listar solic
        	System.out.println(" bienvenidos ssssssssssss");
        	
        	//solicitudesOntologia.deleteSolicitud("Solicitud_1");
        	solicitudesOntologia.addSolicitudConConexion("Solicitud30",3,14600.5);
        	solicitudesOntologia.listarSolicitudes();

            
        } finally {
            // It is best to close the connection in a finally block
            connection.close();
        }
    }*/

}