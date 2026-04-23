package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.EvidenciaResolucion;

@Repository
public interface EvidenciaResolucionRepository extends JpaRepository<EvidenciaResolucion, Integer>{

}
