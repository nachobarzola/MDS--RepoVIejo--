package mds.trabajopractico.sistemabecasalimentarias.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;
import mds.trabajopractico.sistemabecasalimentarias.domain.EnfermedadCronica;
import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.domain.GrupoFamiliar;
import mds.trabajopractico.sistemabecasalimentarias.domain.Hermano;
import mds.trabajopractico.sistemabecasalimentarias.domain.ProgenitorTutor;
import mds.trabajopractico.sistemabecasalimentarias.domain.Turno;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.AlumnoRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.DireccionRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.EnfermedadCronicarepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.GrupoFamiliarRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.HermanoRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.ProgenitorTutorRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.EscuelaService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlumnoServiceImpTest {

	@Autowired
	AlumnoService alumnoService;

	@Autowired
	EscuelaService escuelaService;
	

	@Test
	void guardar_alumno_sin_escuela_GrupoFamiliar() {
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
		assertTrue(optAlumno.isPresent());
	}

	@Test
	void buscar_alumno() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Hernandez 896", "Parana", "3100");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "Blanco", "Argentina", "395783489", "Ariel@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// Ahora lo busco
		Optional<Alumno> optAlumnoRec = alumnoService.getAlumno(optAlumno.get().getId());
		assertTrue(optAlumnoRec.isPresent());
	}

	@Test
	void agregar_alumnoAEscuela() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Lisa", "Simpsons", "EEUU", "395783489", "Lisa@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// Creo escuela
		Escuela escuela = new Escuela("JFHSKVMSE", "siempreViva");
		escuelaService.guardarEscuela(escuela);

		Optional<Alumno> optAlumnoActualizado = alumnoService.agregarEscuelaAlumno(escuela, optAlumno.get().getId());
		assertTrue(optAlumnoActualizado.isPresent());
		assertNotNull(optAlumnoActualizado.get().getEscuela());

	}

	@Test
	void agregar_grupoFamiliarAAlumno() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Camila", "Palermo", "Argentina", "395783489", "CamilaPale@gmail.com",
				"+543536458203", "2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// ------------------------Creo grupo familiar
		GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
		// Progenitor
		ProgenitorTutor progenitor = new ProgenitorTutor("Don Juan", "Palermo", 100000.00, 55, "Pule pisos", "Oficina",
				true, grupoFamiliar);
		grupoFamiliar.addProgenitorTutor(progenitor);
		// Hermanos
		Hermano h1 = new Hermano(25, "Pule picaportes", "", true, grupoFamiliar);
		Hermano h2 = new Hermano(20, "Pule picaportes", "", true, grupoFamiliar);
		Hermano h3 = new Hermano(14, "", "Escuela sin nombre", true, grupoFamiliar);
		grupoFamiliar.addHermano(h1);
		grupoFamiliar.addHermano(h2);
		grupoFamiliar.addHermano(h3);
		// EnfermedadCronica
		EnfermedadCronica enfermedadCronica1 = new EnfermedadCronica("Hipertension", 5000.00, grupoFamiliar);
		grupoFamiliar.addEnfermedadCronica(enfermedadCronica1);
		// Guardamos el grupo familiar
		alumnoService.guardarGrupoFamiliar(grupoFamiliar);
		// ---------------------------------------------------------
		// Agregamos el grupo familiar al alumno
		Optional<Alumno> optAlumnoActualizado = alumnoService.agregarGrupoFamiliarAAlumno(grupoFamiliar,
				optAlumno.get().getId());
		assertTrue(optAlumnoActualizado.isPresent());
		assertNotNull(optAlumnoActualizado.get().getGrupoFamiliar());

	}
}
