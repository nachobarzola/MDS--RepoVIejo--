package mds.trabajopractico.sistemabecasalimentarias.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mds.trabajopractico.sistemabecasalimentarias.domain.EnfermedadCronica;

@Repository
public interface EnfermedadCronicarepository extends JpaRepository<EnfermedadCronica, Integer>{

}
