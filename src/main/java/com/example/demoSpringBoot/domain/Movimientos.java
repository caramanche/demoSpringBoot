package com.example.demoSpringBoot.domain;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity
@Table(name = "MOVIMIENTOS")
@SequenceGenerator(
        name="seqMovimientos",
        sequenceName = "SEQ_MOVIMIENTOS",
        initialValue=1,
        allocationSize=1
)
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMovimientos")
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "FECHA", nullable = false, length = 30)
    private LocalDate fecha;

    @Basic
    @Column(name = "TIPO", nullable = false, length = 30)
    private String tipoMovimiento;

    @Basic
    @Column(name = "VALOR", nullable = false, length = 20)
    private int valor;

    @Basic
    @Column(name = "SALDO", nullable = false, length = 20)
    private int saldo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_MOVIM_CUENTA")
    private Cuenta cuenta;


}
