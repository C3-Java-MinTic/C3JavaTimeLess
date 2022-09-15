package com.example.minticspring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name="name")
    private String name;

    @Column(name="document")
    private String document;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="createdAt")
    private LocalDate createdAt;

    @Column(name="updateAt")
    private LocalDate updateAt;

}
