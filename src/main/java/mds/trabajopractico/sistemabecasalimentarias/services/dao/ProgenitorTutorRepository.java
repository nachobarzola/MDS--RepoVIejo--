package mds.trabajopractico.sistemabecasalimentarias.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mds.trabajopractico.sistemabecasalimentarias.domain.ProgenitorTutor;

@Repository
public interface ProgenitorTutorRepository extends JpaRepository<ProgenitorTutor, Integer>{

}
