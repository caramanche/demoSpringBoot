package com.example.demoSpringBoot.services;


import com.example.demoSpringBoot.beans.ClienteDTO;
import com.example.demoSpringBoot.domain.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientesService {

    ClienteDTO crear(ClienteDTO cliente);

    List<Cliente> consultar();

    ResponseEntity<Cliente> actualizar(Long id, Cliente cli);

    ResponseEntity<Cliente> eliminar(Long id);

}
