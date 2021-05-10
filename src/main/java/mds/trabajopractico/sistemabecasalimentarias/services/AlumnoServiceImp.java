package mds.trabajopractico.sistemabecasalimentarias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService{
	private List<Alumno> listaAlumno = new ArrayList<>();

	@Override
	public Optional<Alumno> guardarAlumno(Alumno alumno) {
		listaAlumno.add(alumno);
		return Optional.of(alumno);
	}

	@Override
	public Optional<Alumno> borrarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> actualizarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> getAlumno(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
