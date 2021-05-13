package mds.trabajopractico.sistemabecasalimentarias.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mds.trabajopractico.sistemabecasalimentarias.domain.BecaAprobada;

@Repository
public interface BecaAprobadaRepository extends JpaRepository<BecaAprobada, Integer>{

}
