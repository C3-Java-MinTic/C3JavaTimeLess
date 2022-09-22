package com.example.minticspring_boot.domain;

import com.example.minticspring_boot.repository.Permisos;
import com.example.minticspring_boot.util.Enum_RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

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
    private LocalDate createdAt;

    @Column(name="updateAt")
    private LocalDate updateAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<Empleado> empleadoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<MovimientoDinero> movimientoDineroCollection;



}
