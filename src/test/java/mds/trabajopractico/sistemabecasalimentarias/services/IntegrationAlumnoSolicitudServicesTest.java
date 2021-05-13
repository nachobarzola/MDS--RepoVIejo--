package mds.trabajopractico.sistemabecasalimentarias.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.domain.ClasificacionSolicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;
import mds.trabajopractico.sistemabecasalimentarias.domain.EnfermedadCronica;
import mds.trabajopractico.sistemabecasalimentarias.domain.GrupoFamiliar;
import mds.trabajopractico.sistemabecasalimentarias.domain.Hermano;
import mds.trabajopractico.sistemabecasalimentarias.domain.ProgenitorTutor;
import mds.trabajopractico.sistemabecasalimentarias.domain.Solicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Turno;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.SolicitudRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.SolicitudService;

@SpringBootTest
class IntegrationAlumnoSolicitudServicesTest {

	@Autowired
	private SolicitudService solicitudService;

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private SolicitudRepository solicitudRepo;

	@Test
	void clasificarSolicitud_becaRechazada() {
		// -----------Creamos el alumno
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2001, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("San Martin 896", "Nogoya", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ailen", "Carmejo", "Argentina", "395965239", "Ailen@gmail.com", "+543533123403",
				"2039822669840", fechaNacimiento, "6to", Turno.Noche, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// --------------Creamos la solicitud
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(2018, 6, 3);
		Date fechaSolicitud = fecha2.getTime();
		//
		Solicitud solicitud1 = new Solicitud(fechaSolicitud, null, alumno1, ClasificacionSolicitud.SolicitudEnEstudio);
		// Guardamos la solicitud
		solicitudService.guardarSolicitud(solicitud1);
		// ------------------------Creo grupo familiar
		GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
		// Progenitor
		ProgenitorTutor progenitor = new ProgenitorTutor("Don Juan", "Palermo", 100000.0, 55, "Pule pisos", "Oficina",
				true, grupoFamiliar);
		grupoFamiliar.addProgenitorTutor(progenitor);
		// Hermanos
		Hermano h1 = new Hermano(25, "Pule picaportes", "", true, grupoFamiliar);
		Hermano h2 = new Hermano(20, "Pule picaportes", "", true, grupoFamiliar);
		grupoFamiliar.addHermano(h1);
		grupoFamiliar.addHermano(h2);
		// EnfermedadCronica
		EnfermedadCronica enfermedadCronica1 = new EnfermedadCronica("Hipertension", 5000.00, grupoFamiliar);
		grupoFamiliar.addEnfermedadCronica(enfermedadCronica1);
		// Guardamos el grupo familiar
		alumnoService.guardarGrupoFamiliar(grupoFamiliar);
		// ---------------------------------------------------------
		// Agregamos el grupo familiar al alumno
		alumnoService.agregarGrupoFamiliarAAlumno(grupoFamiliar, optAlumno.get().getId());
		
		//Clasificamos solicitud
		ClasificacionSolicitud clasificacion= solicitudService.clasificarSolicitud(solicitud1);
		
		assertEquals(ClasificacionSolicitud.SolicitudRechazada, clasificacion);
	}

}
