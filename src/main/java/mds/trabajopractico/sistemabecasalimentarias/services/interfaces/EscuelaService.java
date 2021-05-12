package mds.trabajopractico.sistemabecasalimentarias.services.interfaces;

import java.util.Optional;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;


public interface EscuelaService {
	public Optional<Escuela> guardarEscuela(Escuela escuela);
	
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave);
}
