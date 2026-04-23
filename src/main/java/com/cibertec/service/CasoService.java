package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Caso;
import com.cibertec.repository.CasoRepository;

@Service
public class CasoService {
	@Autowired
    private CasoRepository repository;

    public List<Caso> listarTodos() {
        return repository.findAll();
    }

    public Caso guardar(Caso caso) {
        return repository.save(caso);
    }
}
