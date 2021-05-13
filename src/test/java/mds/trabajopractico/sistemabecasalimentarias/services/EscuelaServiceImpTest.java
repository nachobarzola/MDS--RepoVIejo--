package mds.trabajopractico.sistemabecasalimentarias.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.EscuelaRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.EscuelaService;

@SpringBootTest
class EscuelaServiceImpTest {
	
	@Autowired 
	EscuelaService escuelaService;
	
	@Autowired
	EscuelaRepository escuelaRepo;

	@Test
	void guardar_escuela() {
		//guardo la escuela
		Escuela escuela = new Escuela("Cod2","Clav2","Nomb2");
		Optional<Escuela> optEsc = escuelaService.guardarEscuela(escuela);
		assertTrue(optEsc.isPresent());
		//Recupero la escuela
		Optional<Escuela> optEscRecup = escuelaRepo.findById(optEsc.get().getId());
		assertTrue(optEscRecup.isPresent());
		
	}

}
