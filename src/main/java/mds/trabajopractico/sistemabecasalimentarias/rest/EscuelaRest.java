package mds.trabajopractico.sistemabecasalimentarias.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	@GetMapping("/login")
	@ApiOperation(value = "Permite loguear a la escuela, se debe ingresar asi: /login?codUnicoEstablecimiento=cod&clave=clave")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Logueo correcto"),
			@ApiResponse(code = 404, message = "La clave ingresada es incorrecta") })
	public ResponseEntity<Escuela> loginEscuela(@RequestParam(required= true) String codUnicoEstablecimiento, @RequestParam(required= true) String clave) {
		if(codUnicoEstablecimiento == null || clave == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.of(escuelaService.loginEscuela(codUnicoEstablecimiento,clave));
		
		
	}
	
}
