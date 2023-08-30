package com.example.demoSpringBoot.services;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Cuenta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CuentasService {

    CuentaDTO crear(CuentaDTO cuenta);
    List<Cuenta> consultar();

    ResponseEntity<Cuenta> actualizar(Long id, Cuenta cli);

    ResponseEntity<Cuenta> eliminar(Long id);

}
