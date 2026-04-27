package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Incidencia;
import com.cibertec.service.IncidenciasServices;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
public class IncidenciaController {
	
	@Autowired
    private IncidenciasServices service;

    @GetMapping
    public List<Incidencia> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia incidencia) {
        return service.registrar(incidencia);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Incidencia> editar(@PathVariable Integer id, @RequestBody Incidencia datos) {
 
        return service.buscarPorId(id).map(incExistente -> {

            if (datos.getEstado() != null) {
                incExistente.setEstado(datos.getEstado());
            }
            
            if (datos.getPrioridad() != null) {
                incExistente.setPrioridad(datos.getPrioridad());
            }
            
            if (datos.getDescripcion() != null) {
                incExistente.setDescripcion(datos.getDescripcion());
            }

            Incidencia actualizada = service.registrar(incExistente);
            return ResponseEntity.ok(actualizada);
            
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Incidencia> porUsuario(@PathVariable Integer usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }
}
