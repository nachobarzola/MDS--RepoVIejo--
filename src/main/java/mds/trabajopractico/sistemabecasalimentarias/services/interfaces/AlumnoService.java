package mds.trabajopractico.sistemabecasalimentarias.services.interfaces;

import java.util.Optional;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;
import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.domain.GrupoFamiliar;

public interface AlumnoService {

	public Optional<Alumno> guardarAlumno(Alumno alumno);
	
	public Optional<Alumno> borrarAlumno(Alumno alumno);
	
	public Optional<Alumno> actualizarAlumno(Alumno alumno);
	
	public Optional<Alumno> getAlumno(Integer id);
	
	public Optional<Direccion> guardarDireccion(Direccion direccion);
	
	public Optional<GrupoFamiliar> guardarGrupoFamiliar(GrupoFamiliar grupoFamiliar);
		
	public Optional<Alumno> agregarEscuelaAlumno(Escuela escuela, Integer idAlumno);
	
	public Optional<Alumno> agregarGrupoFamiliarAAlumno(GrupoFamiliar grupFamiliar, Integer idAlumno);
	
	
}
