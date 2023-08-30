package com.example.demoSpringBoot.services;

import com.example.demoSpringBoot.beans.ClienteDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Persona;
import com.example.demoSpringBoot.respository.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    private ClientesRepository clientesRepository;

    @Autowired
    public ClientesServiceImpl(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public ClienteDTO crear(ClienteDTO clienteDTO){

        Persona persona = new Persona();
        persona.setNombre(clienteDTO.getNombre());
        persona.setGenero(clienteDTO.getGenero());
        persona.setEdad(clienteDTO.getEdad());
        persona.setIdentificacion(clienteDTO.getIdentificacion());
        persona.setDireccion(clienteDTO.getDireccion());
        persona.setTelefono(clienteDTO.getTelefono());

        Cliente cliente = new Cliente();
        cliente.setContraseña(clienteDTO.getContraseña());
        cliente.setEstado(clienteDTO.isEstado());
        cliente.setPersona(persona);

        Cliente clienteSave = this.clientesRepository.save(cliente);
        ClienteDTO clienteResp = new ClienteDTO();
        clienteResp.setId(clienteSave.getId());
        clienteResp.setClienteId(clienteSave.getClienteId());
        clienteResp.setNombre(clienteSave.getPersona().getNombre());
        clienteResp.setGenero(clienteSave.getPersona().getGenero());
        clienteResp.setEdad(clienteSave.getPersona().getEdad());

        clienteResp.setIdentificacion(clienteSave.getPersona().getIdentificacion());
        clienteResp.setDireccion(clienteSave.getPersona().getDireccion());
        clienteResp.setTelefono(clienteSave.getPersona().getTelefono());
        clienteResp.setContraseña(clienteSave.getContraseña());
        clienteResp.setEstado(clienteSave.isEstado());

        return clienteResp;

    }
    public List<Cliente> consultar(){
        return (List<Cliente>) this.clientesRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Cliente> actualizar(Long id, Cliente cli) {
        if (!clientesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clientesRepository.findById(id).orElse(null);

        if (cliente != null) {
            cliente.setEstado(cli.isEstado());
            cliente.setContraseña(cli.getContraseña());
            clientesRepository.save(cliente);
        }

        return ResponseEntity.ok(cliente);
    }

    public ResponseEntity<Cliente> eliminar(Long id){
        if (!clientesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.clientesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
