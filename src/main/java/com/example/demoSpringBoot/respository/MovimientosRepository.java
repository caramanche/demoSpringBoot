package com.example.demoSpringBoot.respository;

import com.example.demoSpringBoot.domain.Movimientos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovimientosRepository extends CrudRepository<Movimientos, Long> {
    @Query("select m from Movimientos m where m.cuenta.id =:idCuenta order by m.id asc")
    Optional<List<Movimientos>> findByCuenta(Long idCuenta);
}
