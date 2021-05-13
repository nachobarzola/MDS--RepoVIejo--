package mds.trabajopractico.sistemabecasalimentarias.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.domain.BecaAprobada;
import mds.trabajopractico.sistemabecasalimentarias.domain.ClasificacionSolicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;
import mds.trabajopractico.sistemabecasalimentarias.domain.Solicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Turno;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.SolicitudRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.SolicitudService;

@SpringBootTest
class SolicitudServiceImpTest {

	@Autowired
	private SolicitudService solicitudService;

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private SolicitudRepository solicitudRepo;

	@Disabled
	void guardar_solicitud() {
		// -----------Creamos el alumno

		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Juan", "Perez", "Argentina", "395783489", "Juan@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// --------------Creamos la solicitud
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(2003, 6, 3);
		Date fechaSolicitud = fecha2.getTime();
		//
		Solicitud solicitud1 = new Solicitud(fechaSolicitud, null, alumno1, ClasificacionSolicitud.SolicitudEnEstudio);
		// Guardamos la solicitud
		Optional<Solicitud> optSolReturn = solicitudService.guardarSolicitud(solicitud1);
		assertTrue(optSolReturn.isPresent());
		// chequeo persistencia
		Optional<Solicitud> optSolReturn2 = solicitudRepo.findById(optSolReturn.get().getId());
		assertTrue(optSolReturn2.isPresent());
	}

	@Test
	void agregar_becaAprobada_a_solicitud() {
		// -----------Creamos el alumno

		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Juan", "Perez", "Argentina", "395783489", "Juan@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// --------------Creamos la solicitud
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(2018, 6, 3);
		Date fechaSolicitud = fecha2.getTime();
		//
		Solicitud solicitud1 = new Solicitud(fechaSolicitud, null, alumno1, ClasificacionSolicitud.SolicitudEnEstudio);
		// Guardamos la solicitud
		Optional<Solicitud> optSolReturn = solicitudService.guardarSolicitud(solicitud1);
		//----------------Creamos beca aprobada
		Calendar fecha3 = Calendar.getInstance();
		fecha3.set(2018, 6, 3);
		Date fechaIncio = fecha3.getTime();
		//
		Calendar fecha4 = Calendar.getInstance();
		fecha4.set(2023, 6, 3);
		Date fechaFin= fecha4.getTime();
		//
		BecaAprobada becaAprobada1 = new BecaAprobada(fechaIncio,fechaFin, solicitud1);
		//Guardamos beca aprobada
		
		//Actualizamos la solicitud
		Optional<Solicitud> optSolReturn2 = solicitudService.agregarBecaAprobada(solicitud1,becaAprobada1);
		assertTrue(optSolReturn2.isPresent());

	}
}
