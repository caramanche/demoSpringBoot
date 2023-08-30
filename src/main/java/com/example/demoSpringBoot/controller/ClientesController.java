package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.ClienteDTO;
import com.example.demoSpringBoot.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/clientes", produces = "application/json; charset=UTF-8")
public interface ClientesController {

    @PostMapping
    ClienteDTO crear(@RequestBody ClienteDTO cliente);

    @GetMapping()
    List<Cliente> consultar();

    @PutMapping("/{id}")
    ResponseEntity<Cliente> actualizar(@PathVariable Long id,
                                       @RequestBody Cliente cli);

    @DeleteMapping("/{id}")
    ResponseEntity<Cliente> eliminar(@PathVariable Long id);

}
