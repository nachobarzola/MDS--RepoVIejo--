package mds.trabajopractico.sistemabecasalimentarias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.EscuelaService;
import mds.trabajopractico.sistemabecasalimentarias.services.repositorios.EscuelaRepository;

@Service
public class EscuelaServiceImp implements EscuelaService {

	@Autowired
	private EscuelaRepository repoEscuela;

	@Override
	public Optional<Escuela> guardarEscuela(Escuela escuela) {
		return Optional.of(repoEscuela.save(escuela));
	}

	@Override
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave) {
		Escuela escuela = repoEscuela.findByCodigoUnicoEstablecimiento(codidoUnicoEstablecimiento);
		// Existe esa escuela
		if (escuela != null) {
			if (escuela.getClave().equals(clave)) {
				return Optional.of(escuela);
			}

		}
		return Optional.empty();
	}
	
	
	
	
}
