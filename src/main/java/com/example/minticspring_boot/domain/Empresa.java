package com.example.minticspring_boot.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "empresa")
public class Empresa {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", unique = true)
    private String name;

    @Column(name="document", unique = true)
    private String document;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="createdAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Column(name="updateAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<Empleado> empleadoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<MovimientoDinero> movimientoDineroCollection;



}
