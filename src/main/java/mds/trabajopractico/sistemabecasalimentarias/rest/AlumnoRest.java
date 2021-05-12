package mds.trabajopractico.sistemabecasalimentarias.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import mds.trabajopractico.sistemabecasalimentarias.domain.Alumno;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRest {
	
	@Autowired
	private AlumnoService alumnoService;
	
	
	@PostMapping
	@ApiOperation(value = "Guarda el cliente recibido en el JSON")
	public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
		return ResponseEntity.of(alumnoService.guardarAlumno(alumno));	
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id){
		return ResponseEntity.of(alumnoService.getAlumno(id));
	}
}
