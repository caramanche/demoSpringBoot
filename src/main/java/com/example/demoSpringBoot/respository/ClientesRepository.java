package com.example.demoSpringBoot.respository;

import com.example.demoSpringBoot.domain.Cliente;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientesRepository extends CrudRepository<Cliente, Long> {
    /*@Query("update Cliente c set c.estado = :estado  where c.id = :id")
    void update(@Parameter("id") Long id,
                   @Param("estado") boolean estado
                   //@Param("contraseña") String contraseña
    );*/
}
