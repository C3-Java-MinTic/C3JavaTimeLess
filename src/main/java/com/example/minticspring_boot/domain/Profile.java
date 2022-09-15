package com.example.minticspring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

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

    @OneToOne(mappedBy = "profile")
    private Empleado empleado;

}
