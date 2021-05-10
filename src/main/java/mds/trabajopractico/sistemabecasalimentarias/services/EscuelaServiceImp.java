package mds.trabajopractico.sistemabecasalimentarias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.EscuelaService;

@Service
public class EscuelaServiceImp implements EscuelaService{
	//TODO: persitencia temporal
	private List<Escuela> listaEscuelas = new ArrayList<>();
	private Integer idGen=1;

	@Override
	public Optional<Escuela> guardarEscuela(Escuela escuela) {
		escuela.setId(idGen++);
		listaEscuelas.add(escuela);
		System.out.println("Escuela nueva: "+escuela.toString());
		return Optional.of(escuela);
	}

}
