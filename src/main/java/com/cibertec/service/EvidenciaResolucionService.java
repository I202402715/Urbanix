package com.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.EvidenciaResolucion;
import com.cibertec.repository.EvidenciaResolucionRepository;

@Service
public class EvidenciaResolucionService {
	@Autowired
    private EvidenciaResolucionRepository repository;

    public EvidenciaResolucion guardar(EvidenciaResolucion evidencia) {
        return repository.save(evidencia);
    }
}
