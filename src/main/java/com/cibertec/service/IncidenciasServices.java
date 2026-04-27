package com.cibertec.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Incidencia;
import com.cibertec.repository.IncidenciaRepository;

@Service
public class IncidenciasServices {
	@Autowired
    private IncidenciaRepository repository;

    public List<Incidencia> listarPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioIdOrderByCreadoEnDesc(usuarioId);
    }

    public Incidencia registrar(Incidencia incidencia) {
        if (incidencia.getId() == null) {
            String codigo = "URB-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            incidencia.setCodigo(codigo);
        }
        return repository.save(incidencia);
    }
    
    public List<Incidencia> listarTodas() {
        return repository.findAll();
    }
    
    public Optional<Incidencia> buscarPorId(Integer id) {
        return repository.findById(id);
    }
}
