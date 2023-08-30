package com.example.demoSpringBoot.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "CLIENTE")
@SequenceGenerator(
        name="seqCliente",
        sequenceName = "SEQ_CLIENTE",
        initialValue=1,
        allocationSize=1
)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "CLIENTE_ID", length = 30)
    private long clienteId;
    //private UUID clienteId;

    @Basic
    @Column(name = "CONTRASEÑA", nullable = false, length = 30)
    private String contraseña;

    @Basic
    @Column(name = "ESTADO", nullable = false, length = 20)
    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CLIENTE_PERSONA")
    private Persona persona;


}
