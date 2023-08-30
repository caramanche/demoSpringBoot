package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Cuenta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/cuentas", produces = "application/json; charset=UTF-8")
public interface CuentasController {

    @PostMapping("/crear")
    CuentaDTO crear(@RequestBody CuentaDTO cliente);

    @GetMapping()
    List<Cuenta> consultar();

    @PutMapping("/{id}")
    ResponseEntity<Cuenta> actualizar(@PathVariable Long id,
                                       @RequestBody Cuenta cuenta);

    @DeleteMapping("/{id}")
    ResponseEntity<Cuenta> eliminar(@PathVariable Long id);


}
