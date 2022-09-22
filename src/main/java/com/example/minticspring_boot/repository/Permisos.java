package com.example.minticspring_boot.repository;

import com.example.minticspring_boot.domain.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "permisos")
public class Permisos {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="crearempresa")
    private Boolean crearempresa;
    @Column(name="crearempleado")
    private Boolean crearempleado;
    @Column(name="crearingreso")
    private Boolean crearingreso;
    @Column(name="crearegreso")
    private Boolean crearegreso;
    @Column(name="listargastosingresos")
    private Boolean listargastosingresos;

    @JoinColumn(name="id_empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    public Permisos() {
    }

    public Permisos(Boolean crearempresa, Boolean crearempleado, Boolean crearingreso, Boolean crearegreso, Boolean listargastosingresos, Empleado idEmpleado) {
        this.crearempresa = crearempresa;
        this.crearempleado = crearempleado;
        this.crearingreso = crearingreso;
        this.crearegreso = crearegreso;
        this.listargastosingresos = listargastosingresos;
        this.idEmpleado = idEmpleado;
    }
}
