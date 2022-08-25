package com.timeless.timeless.domain;

import java.util.Date;

public class Empleado {

    private long id;
    private String email;
    private Date updatedAt;
    private Date createdAt;

    public Empleado(long id, String email, Date updatedAt, Date createdAt) {
        this.id = id;
        this.email = email;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}