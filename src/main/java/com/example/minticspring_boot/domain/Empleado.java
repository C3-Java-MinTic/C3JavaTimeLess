package com.example.minticspring_boot.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Empleado {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private LocalDate updatedAt;
    @Getter @Setter
    private LocalDate createdAt;

    public Empleado(long id, String email, LocalDate updatedAt, LocalDate createdAt) {
        this.id = id;
        this.email = email;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Empleado() {

    }
}
