package mds.tp.becaalimentaria.presentacion;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.GestorAlumno;
import mds.tp.becaalimentaria.gestores.GestorSolicitud;
import mds.tp.becaalimentaria.ontologia.SolicitudesOntologia;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Optional;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class AltaSolicitudJPanel extends JPanel {

	private JFrame frmAltaSolicitud;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblEstadoSolic;
	private JTextField tfBusqueda;
	private JLabel lblNombreValor;
	private JLabel lblApellidoValor;
	private JLabel lblDniValor;
	private JLabel lblTituloBusqueda;
	private JLabel lblTituloDatos;
	private JButton btnConsultar;
	private JButton btnCrearSolicitud;
	private JButton btnAtras;
	private MenuJFrame menuJFrame;
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	private GestorSolicitud solicitudService = GestorSolicitud.getInstance();
	private Alumno alumnoObtenido;
	private Escuela escuelaLogeada;
	private ClasificacionSolicitud clasificacionSolicitud;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	public AltaSolicitudJPanel(final MenuJFrame menuJFrame, Escuela escuela) {
		this.menuJFrame = menuJFrame;
		this.escuelaLogeada = escuela;
		// ----- LABEL ----//

		setLayout(null);
		lblTituloBusqueda = new JLabel("Ingrese el número de documento del alumno");
		lblTituloBusqueda.setBounds(86, 55, 300, 20);
		add(lblTituloBusqueda);

		lblTituloDatos = new JLabel("Datos del alumno");
		lblTituloDatos.setBounds(146, 130, 250, 20);
		lblTituloDatos.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblTituloDatos);

		lblDni = new JLabel("Documento");
		lblDni.setBounds(106, 180, 100, 20);
		lblDni.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDni);

		lblDniValor = new JLabel(""); // traer de la BD
		lblDniValor.setBounds(186, 180, 200, 20);
		lblDniValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDniValor);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(106, 220, 100, 20);
		lblNombre.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombre);

		lblNombreValor = new JLabel(""); // traer de la BD
		lblNombreValor.setBounds(186, 220, 200, 20);
		lblNombreValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombreValor);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(106, 260, 100, 20);
		lblApellido.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellido);

		lblApellidoValor = new JLabel(""); // traer de la BD
		lblApellidoValor.setBounds(186, 260, 200, 20);
		lblApellidoValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellidoValor);

		lblEstadoSolic = new JLabel("Solicitud:"); // traer de la BD
		lblEstadoSolic.setBounds(146, 360, 200, 20);
		lblEstadoSolic.setVisible(true); // habilitar si se encuentra el alumno en la BD

		add(lblEstadoSolic);

		// ---- TEXTFIELD ----//

		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(126, 90, 150, 20);
		add(tfBusqueda);
		//Validacion ingreso de solo numeros y hasta 8 digitos
		tfBusqueda.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyTyped(KeyEvent e){
				int max = 7;
				char caracter = e.getKeyChar();
				if(((caracter < '0') ||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
				if(tfBusqueda.getText().length() > max) {
					e.consume();
				}
			}
		});

		// ----- BUTTON ------//

		/*btnConsultar = new JButton("Consultar estado");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				
				
				clasificacionSolicitud = solicitudService.clasificarSolicitud(alumnoObtenido);
				lblEstadoSolic.setText("Solicitud: "+String.valueOf(clasificacionSolicitud));
				btnCrearSolicitud.setEnabled(true);
			}
		});
		btnConsultar.setBounds(126, 310, 150, 20);
		btnConsultar.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnConsultar); */

		btnCrearSolicitud = new JButton("Crear solicitud");
		btnCrearSolicitud.setEnabled(false);
		btnCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date fechaActual = new Date(System.currentTimeMillis());
				Solicitud solicitudNueva = new Solicitud();
				solicitudNueva.setFecha(fechaActual);
				solicitudNueva.setAlumnoSolicitante(alumnoObtenido);
				
				// ---- --- creacion de la solicitud en la ontologia --- ---
				
				// conexion
				HTTPRepository repository = new HTTPRepository("http://localhost:7200/repositories/tpOntologias");

		        
		        RepositoryConnection connection = repository.getConnection();
				SolicitudesOntologia solicitudesOntologia = new SolicitudesOntologia(connection);				
				
				//ingresos de progenitores - gastos de enfermedades
				Double sumaIngresoNetoFamiliar = alumnoService.getIngresoFamiliarTotal(alumnoObtenido);
				Double sumaGastoEnfermedad = alumnoService.getGastoEnfermedadCronica(alumnoObtenido);
				Double diferenciaIngresoGasto = sumaIngresoNetoFamiliar - sumaGastoEnfermedad;
				
				//numero de hermanos
				Integer cantidadHermanos = alumnoService.getCantidadHermanos(alumnoObtenido);

				
				
				//--- --- fin de creacion de solicitud en ontologia --- --- 
				
				
				
				//clasificacion
				
				clasificacionSolicitud = solicitudService.clasificarSolicitud(alumnoObtenido);
				lblEstadoSolic.setText("Solicitud: "+String.valueOf(clasificacionSolicitud));
				btnCrearSolicitud.setEnabled(true);
				
				//fin de clasificacion
				
				solicitudNueva.setClasificacionSolicitud(clasificacionSolicitud);
				if((solicitudService.guardarSolicitud(solicitudNueva)).isPresent()) {
					
					//se guarda aca la solicitud en la ontologia
					Integer idSolicitud = (solicitudService.getMaxID()).get().getId();
					String nombreSolicitud="Solicitud"+idSolicitud;
					solicitudesOntologia.addSolicitud(nombreSolicitud,cantidadHermanos,diferenciaIngresoGasto,idSolicitud);
					//fin guardado en ontologia
					
					String text = "La solicitud se creó satisfactoriamente";
				    String title = "Exito";
				    int optionType = JOptionPane.DEFAULT_OPTION;
				    int result = JOptionPane.showConfirmDialog(menuJFrame, text, title, optionType);
				    if (result == JOptionPane.OK_OPTION) {
				       menuJFrame.cambiarVentanaMenu(1);
				    }
					
				} else {
					JOptionPane.showMessageDialog(frmAltaSolicitud, "No se pudo crear la solicitud", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnCrearSolicitud.setBounds(206, 400, 140, 20);
		btnCrearSolicitud.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnCrearSolicitud);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(86, 400, 100, 20);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaSolicitudJPanel.this.menuJFrame.cambiarVentanaMenu(5,escuelaLogeada);
			}
		});
		

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Optional<Alumno> optAlumnoObtenido = alumnoService.findByDniYEscuela(tfBusqueda.getText(),escuelaLogeada);
				if(optAlumnoObtenido.isPresent()) {
					alumnoObtenido = optAlumnoObtenido.get();
					actualizarInterfaz(optAlumnoObtenido.get());
					//btnConsultar.setEnabled(true);
					btnCrearSolicitud.setEnabled(true);
				}
				else {
					JOptionPane.showMessageDialog(frmAltaSolicitud, "El alumno no se encuentra registrado", "Error",
							JOptionPane.ERROR_MESSAGE);
					//btnConsultar.setEnabled(false);
					btnCrearSolicitud.setEnabled(false);

				}
				
				
			}
		});
		btnBuscar.setBounds(286, 89, 89, 23);
		add(btnBuscar);
		//btnConsultar.setEnabled(false);

	}

	private void actualizarInterfaz(Alumno alumnoObtenido) {
		lblNombreValor.setText(alumnoObtenido.getNombre());
		lblApellidoValor.setText(alumnoObtenido.getApellido());
		lblDniValor.setText(alumnoObtenido.getDni());

	}

}
