package com.example.minticspring_boot.domain;

import com.example.minticspring_boot.repository.Permisos;
import com.example.minticspring_boot.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


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

    @Column(name="nombres")
    private String nombres;


    @Column(name="phone")
    private String phone;


    @Column(name="email", unique = true)
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Enum_RoleName role;

    @Column(name="updatedAt")
    private LocalDate updatedAt;

    @Column(name="createdAt")
    private LocalDate createdAt;

    @JoinColumn(name="id_empresa", referencedColumnName = "id")
    @ManyToOne()
    private Empresa idEmpresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    @JsonIgnore
    private Collection<Permisos> permisosCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<MovimientoDinero> movimientoDineroCollection;

    @OneToOne
    @JoinColumn(name = "FK_Profile")
    private Profile profile;




}
