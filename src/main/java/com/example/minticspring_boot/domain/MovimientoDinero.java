package com.example.minticspring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="concept")
    private String concept;

    @Column(name="amount")
    private float amount;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="updateAt")
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name="empleado-movimientodinero")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="empresa-movimientodinero")
    private Empresa empresa;


}
