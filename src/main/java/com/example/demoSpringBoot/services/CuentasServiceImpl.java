package com.example.demoSpringBoot.services;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Cuenta;
import com.example.demoSpringBoot.respository.ClientesRepository;
import com.example.demoSpringBoot.respository.CuentasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentasServiceImpl implements CuentasService {

    private CuentasRepository cuentasRepository;
    private ClientesRepository clientesRepository;

    @Autowired
    public CuentasServiceImpl(CuentasRepository cuentasRepository,
                              ClientesRepository clientesRepository){
        this.cuentasRepository = cuentasRepository;
        this.clientesRepository = clientesRepository;

    }

    public CuentaDTO crear(CuentaDTO cuentaDTO){

        Optional<Cliente> cliente =
                this.clientesRepository.findById(cuentaDTO.getIdCliente());

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setCliente(cliente.get());

        Cuenta cuentaSave = this.cuentasRepository.save(cuenta);
        CuentaDTO cuentaResp = new CuentaDTO();
        cuentaResp.setId(cuentaSave.getId());
        cuentaResp.setNumeroCuenta(cuentaSave.getNumeroCuenta());
        cuentaResp.setTipoCuenta(cuentaSave.getTipoCuenta());
        cuentaResp.setSaldoInicial(cuentaSave.getSaldoInicial());
        cuentaResp.setEstado(cuentaSave.getCliente().isEstado());
        cuentaResp.setIdCliente(cuentaSave.getCliente().getId());
        cuentaResp.setNombre(cuentaSave.getCliente().getPersona().getNombre());
        return cuentaResp;

    }

    public List<Cuenta> consultar(){
        return (List<Cuenta>) this.cuentasRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Cuenta> actualizar(Long id, Cuenta cli) {
        if (!cuentasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Cuenta cuenta = cuentasRepository.findById(id).orElse(null);

        if (cuenta != null) {
            cuenta.setTipoCuenta(cuenta.getTipoCuenta());
            cuentasRepository.save(cuenta);
        }
        return ResponseEntity.ok(cuenta);
    }

    public ResponseEntity<Cuenta> eliminar(Long id){
        if (!cuentasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.cuentasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
