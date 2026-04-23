package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Caso;
import com.cibertec.service.CasoService;

@RestController
@RequestMapping("/api/casos")
@CrossOrigin(origins = "*")
public class CasoController {
    @Autowired
    private CasoService service;

    @GetMapping
    public List<Caso> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Caso crear(@RequestBody Caso caso) {
        return service.guardar(caso);
    }
}