package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.domain.Cuenta;
import com.example.demoSpringBoot.services.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CuentasControllerImpl implements CuentasController {

    private CuentasService cuentasService;

    @Autowired
    public CuentasControllerImpl(CuentasService cuentasService){
        this.cuentasService = cuentasService;
    }

    public CuentaDTO crear(CuentaDTO cuenta){
        return this.cuentasService.crear(cuenta);

    }
    public List<Cuenta> consultar(){
        return this.cuentasService.consultar();
    }

    public ResponseEntity<Cuenta> actualizar(Long id, Cuenta cuenta){
        return this.cuentasService.actualizar(id, cuenta);
    }

    public ResponseEntity<Cuenta> eliminar(Long id) {
        return this.cuentasService.eliminar(id);
    }
}
