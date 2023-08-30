package com.example.demoSpringBoot.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERSONA")
@SequenceGenerator(
        name="seqPersona",
        sequenceName = "SEQ_PERSONA",
        initialValue=1,
        allocationSize=1
)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersona")
    @Column(name = "ID", nullable = false)
    private long id;

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Basic
    @Column(name = "GENERO", length = 30)
    private String genero;

    @Basic
    @Column(name = "EDAD", length = 20)
    private int edad;

    @Basic
    @Column(name = "IDENTIFICACION", length = 20)
    private String identificacion;

    @Basic
    @Column(name = "DIRECCION", nullable = false, length = 30)
    private String direccion;

    @Basic
    @Column(name = "TELEFONO", nullable = false, length = 20)
    private String telefono;

}
