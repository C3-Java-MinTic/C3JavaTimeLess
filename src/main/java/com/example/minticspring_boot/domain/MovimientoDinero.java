package com.example.minticspring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Column(name="updateAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    @JoinColumn(name="id_empleado", referencedColumnName = "id", updatable = true, insertable = true)
    @ManyToOne()
    private Empleado idEmpleado;

    @JoinColumn(name="id_empresa", referencedColumnName = "id", updatable = true, insertable = true)
    @ManyToOne()
    private Empresa idEmpresa;




}
