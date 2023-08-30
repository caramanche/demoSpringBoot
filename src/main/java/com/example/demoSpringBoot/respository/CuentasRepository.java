package com.example.demoSpringBoot.respository;

import com.example.demoSpringBoot.domain.Cliente;
import com.example.demoSpringBoot.domain.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CuentasRepository extends CrudRepository<Cuenta, Long> {
    Optional<Cuenta> findById(Long id);

}
