package com.example.demoSpringBoot.services;

import com.example.demoSpringBoot.beans.CuentaDTO;
import com.example.demoSpringBoot.beans.MovimientoDTO;
import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Cuenta;
import com.example.demoSpringBoot.domain.Movimientos;
import com.example.demoSpringBoot.respository.ClientesRepository;
import com.example.demoSpringBoot.respository.CuentasRepository;
import com.example.demoSpringBoot.respository.MovimientosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    private MovimientosRepository movimientosRepository;
    private CuentasRepository cuentasRepository;
    private ClientesRepository clientesRepository;

    @Autowired
    public MovimientosServiceImpl(MovimientosRepository movimientosRepository,
                                  CuentasRepository cuentasRepository,
                                  ClientesRepository clientesRepository){
        this.movimientosRepository = movimientosRepository;
        this.cuentasRepository = cuentasRepository;
        this.clientesRepository = clientesRepository;

    }

    public MovimientoDTO crear(MovimientoDTO movimiDTO){

        Optional<Cuenta> cuenta =
                this.cuentasRepository.findById(movimiDTO.getIdCuenta());

        Optional<List<Movimientos>> movimiIni =
                this.movimientosRepository.findByCuenta(movimiDTO.getIdCuenta());

        Movimientos movimi = new Movimientos();
        movimi.setFecha(movimiDTO.getFecha());
        movimi.setTipoMovimiento(movimiDTO.getTipoMovimiento());
        movimi.setValor(movimiDTO.getValor());

        int saldoFinal = 0;
        if(movimiIni.isPresent() && !movimiIni.get().isEmpty()){
            Movimientos lastMov = movimiIni.get().get(movimiIni.get().size() -1);
            saldoFinal = lastMov.getSaldo() - movimiDTO.getValor();
        }else {
            saldoFinal = cuenta.get().getSaldoInicial() - movimiDTO.getValor();

        }
        movimi.setSaldo(saldoFinal);
        movimi.setCuenta(cuenta.get());

        Movimientos movimiSave = this.movimientosRepository.save(movimi);
        MovimientoDTO movimiResp = new MovimientoDTO();
        movimiResp.setId(movimiSave.getId());
        movimiResp.setFecha(movimiSave.getFecha());
        movimiResp.setTipoMovimiento(movimiSave.getTipoMovimiento());
        movimiResp.setValor(movimiSave.getValor());
        movimiResp.setSaldo(movimiSave.getSaldo());
        movimiResp.setIdCuenta(movimiSave.getCuenta().getId());
        return movimiResp;

    }

    public List<Movimientos> consultar(){
        return (List<Movimientos>) this.movimientosRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Movimientos> actualizar(Long id, Movimientos movi) {
        if (!movimientosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Movimientos movimiento = movimientosRepository.findById(id).orElse(null);

        if (movimiento != null) {
            movimiento.setValor(movi.getValor());
            movimiento.setFecha(movi.getFecha());
            movimientosRepository.save(movimiento);
        }

        return ResponseEntity.ok(movimiento);
    }

    public ResponseEntity<Movimientos> eliminar(Long id){
        if (!movimientosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.movimientosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
