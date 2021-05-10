package mds.trabajopractico.sistemabecasalimentarias.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.EscuelaService;

@RestController
@RequestMapping("/api/escuela")
public class EscuelaRest {
	
	@Autowired
	public EscuelaService escuelaService;

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@PostMapping
	public ResponseEntity<Escuela> crearEscuela(@RequestBody Escuela nuevaEsc) {
		return ResponseEntity.of(escuelaService.guardarEscuela(nuevaEsc));
	}
	
}
