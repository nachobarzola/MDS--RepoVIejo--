package mds.trabajopractico.sistemabecasalimentarias.services.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;


@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Integer>{
	Escuela findByCodigoUnicoEstablecimiento(String codidoUnicoEstablecimiento);
	
}
