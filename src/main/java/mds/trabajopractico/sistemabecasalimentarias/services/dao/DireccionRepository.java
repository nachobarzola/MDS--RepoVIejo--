package mds.trabajopractico.sistemabecasalimentarias.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mds.trabajopractico.sistemabecasalimentarias.domain.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{

}
