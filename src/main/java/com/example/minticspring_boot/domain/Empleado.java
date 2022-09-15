package com.example.minticspring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="email")
    private String email;

    @Column(name="updatedAt")
    private LocalDate updatedAt;

    @Column(name="createdAt")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name="empresa-empleados")
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")
    private List<MovimientoDinero> movimientodineros;

    @OneToOne
    @JoinColumn(name="empleado-profile")
    private Profile profile;



}
