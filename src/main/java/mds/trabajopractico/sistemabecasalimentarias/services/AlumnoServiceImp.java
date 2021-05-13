package mds.trabajopractico.sistemabecasalimentarias.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;
import mds.trabajopractico.sistemabecasalimentarias.domain.EnfermedadCronica;
import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.domain.GrupoFamiliar;
import mds.trabajopractico.sistemabecasalimentarias.domain.Hermano;
import mds.trabajopractico.sistemabecasalimentarias.domain.ProgenitorTutor;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.AlumnoRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.DireccionRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.EnfermedadCronicarepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.GrupoFamiliarRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.HermanoRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.ProgenitorTutorRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService{
	
	//----------------Repositorios - Acceso a datos.
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private DireccionRepository direccionRepo;
	
	@Autowired
	private GrupoFamiliarRepository grupoFamiliarRepo;
	
	@Autowired
	private HermanoRepository hermanoRepo;
	
	@Autowired
	private ProgenitorTutorRepository progenitorTutorRepo;
	
	@Autowired
	private EnfermedadCronicarepository enfermedadCronicaRepo;
	//---------------------------------------------------
	
	@Override
	public Optional<Alumno> guardarAlumno(Alumno alumno) {
		alumnoRepo.save(alumno);
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
		return alumnoRepo.findById(id);
		
	}

	@Override
	public Optional<Direccion> guardarDireccion(Direccion direccion) {
		return Optional.of(direccionRepo.save(direccion));
	}

	@Override
	public Optional<Alumno> agregarEscuelaAlumno(Escuela escuela, Integer idAlumno) {
		Optional<Alumno> optAlumno = alumnoRepo.findById(idAlumno);
		if(optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			alumno.setEscuela(escuela);
			escuela.addAlumno(alumno);
			return Optional.of(alumnoRepo.save(alumno));
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<Alumno> agregarGrupoFamiliarAAlumno(GrupoFamiliar grupFamiliar, Integer idAlumno) {
		Optional<Alumno> optAlumno = alumnoRepo.findById(idAlumno);
		if(optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			//Verificamos si el grupo familiar existe
			if(grupoFamiliarRepo.findById(grupFamiliar.getId()) != null) {
				alumno.setGrupoFamiliar(grupFamiliar);
				return Optional.of(alumnoRepo.save(alumno));
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<GrupoFamiliar> guardarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		if(grupoFamiliarRepo.save(grupoFamiliar) != null) {
			if(grupoFamiliar.getListaHermano().size() > 0) {
				//tiene hermanos, Los que guardan la relacion es la clase hermano
				//Debo guardar relacion por cada hermano
				for(Hermano unHer: grupoFamiliar.getListaHermano()) {
					hermanoRepo.save(unHer);
				}
			}
			if(grupoFamiliar.getListaProgenitorTutor().size() > 0) {
				//Tiene progenitor, Los que guardan la relacion es la clase progenitorTutor
				//Debo guardar relacion por cada progenitorTutor
				for(ProgenitorTutor unProg: grupoFamiliar.getListaProgenitorTutor()) {
					progenitorTutorRepo.save(unProg);
				}
			}
			if(grupoFamiliar.getListaEnfermedadCronica().size() > 0) {
				//Tiene EnfermedadCronica, Los que guardan la relacion es la clase EnfermedadCronica
				//Debo guardar relacion por cada EnfermedadCronica
				for(EnfermedadCronica unaEnf: grupoFamiliar.getListaEnfermedadCronica()) {
					enfermedadCronicaRepo.save(unaEnf);
				}
			}
			return Optional.of(grupoFamiliar);
		}
		
		return Optional.empty();
	}

}
