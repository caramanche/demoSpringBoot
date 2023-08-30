package com.example.demoSpringBoot.services;

import com.example.demoSpringBoot.beans.MovimientoDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Movimientos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovimientosService {

    MovimientoDTO crear(MovimientoDTO movimi);

    List<Movimientos> consultar();

    ResponseEntity<Movimientos> actualizar(Long id, Movimientos cli);

    ResponseEntity<Movimientos> eliminar(Long id);

}
