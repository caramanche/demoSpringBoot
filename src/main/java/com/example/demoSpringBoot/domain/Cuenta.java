package com.example.demoSpringBoot.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "CUENTA")
@SequenceGenerator(
        name="seqCuenta",
        sequenceName = "SEQ_CUENTA",
        initialValue=1,
        allocationSize=1
)
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCuenta")
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "NUMERO", nullable = false, length = 30)
    private String numeroCuenta;

    @Basic
    @Column(name = "TIPO", nullable = false, length = 30)
    private String tipoCuenta;

    @Basic
    @Column(name = "SALDO_INICIAL", nullable = false, length = 20)
    private int saldoInicial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CUENTA_CLIENTE")
    private Cliente cliente;

}
