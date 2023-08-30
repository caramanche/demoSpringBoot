package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.MovimientoDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Movimientos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/movimientos", produces = "application/json; charset=UTF-8")
public interface MovimientosController {

    @PostMapping("/crear")
    MovimientoDTO crear(@RequestBody MovimientoDTO movimi);

    @GetMapping()
    List<Movimientos> consultar();

    @PutMapping("/{id}")
    ResponseEntity<Movimientos> actualizar(@PathVariable Long id,
                                       @RequestBody Movimientos movimi);

    @DeleteMapping("/{id}")
    ResponseEntity<Movimientos> eliminar(@PathVariable Long id);

}
