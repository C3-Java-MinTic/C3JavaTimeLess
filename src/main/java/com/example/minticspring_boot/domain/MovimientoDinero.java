package com.example.minticspring_boot.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class MovimientoDinero {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String concept;
    @Getter @Setter
    private float amount;
    @Getter @Setter
    private Date createdAt;
    @Getter @Setter
    private Date updateAt;

    public MovimientoDinero(long id, String concept, float amount, Date createdAt, Date updateAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
