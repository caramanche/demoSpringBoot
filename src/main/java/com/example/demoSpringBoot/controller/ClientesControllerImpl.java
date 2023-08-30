package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.beans.ClienteDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientesControllerImpl implements ClientesController {

    private ClientesService clientesService;

    @Autowired
    public ClientesControllerImpl(ClientesService clientesService){
        this.clientesService = clientesService;
    }

    public ClienteDTO crear(ClienteDTO cliente){
        return this.clientesService.crear(cliente);
    }

    public List<Cliente> consultar(){
        return this.clientesService.consultar();
    }

    public ResponseEntity<Cliente> actualizar(Long id, Cliente cli){
        return this.clientesService.actualizar(id, cli);
    }

    public ResponseEntity<Cliente> eliminar(Long id) {
        return this.clientesService.eliminar(id);
    }

}
