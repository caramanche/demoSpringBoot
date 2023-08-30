package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.beans.MovimientoDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Movimientos;
import com.example.demoSpringBoot.services.CuentasService;
import com.example.demoSpringBoot.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientosControllerImpl implements MovimientosController {

    private MovimientosService movimientosService;

    @Autowired
    public MovimientosControllerImpl(MovimientosService movimientosService){
        this.movimientosService = movimientosService;
    }

    public MovimientoDTO crear(MovimientoDTO movimi){
        return this.movimientosService.crear(movimi);

    }

    public List<Movimientos> consultar(){
        return this.movimientosService.consultar();
    }

    public ResponseEntity<Movimientos> actualizar(Long id, Movimientos movi){
        return this.movimientosService.actualizar(id, movi);
    }

    public ResponseEntity<Movimientos> eliminar(Long id) {
        return this.movimientosService.eliminar(id);
    }
}
