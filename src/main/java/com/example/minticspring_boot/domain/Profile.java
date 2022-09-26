package com.example.minticspring_boot.domain;

import com.example.minticspring_boot.repository.Permisos;
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
@Table(name= "profile")
public class Profile {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="image")
    private String image;

    @Column(name="phone")
    private String phone;

    @Column(name="createdAt")
    private LocalDate createdAt;

    @Column(name="updatedAt")
    private LocalDate updatedAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profile")
    private Empleado empleado;



}
