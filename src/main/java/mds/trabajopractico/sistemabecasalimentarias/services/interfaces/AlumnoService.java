package mds.trabajopractico.sistemabecasalimentarias.services.interfaces;

import java.util.Optional;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;

public interface AlumnoService {

	public Optional<Alumno> guardarAlumno(Alumno alumno);
	
	public Optional<Alumno> borrarAlumno(Alumno alumno);
	
	public Optional<Alumno> actualizarAlumno(Alumno alumno);
	
	public Optional<Alumno> getAlumno(Integer id);
}
