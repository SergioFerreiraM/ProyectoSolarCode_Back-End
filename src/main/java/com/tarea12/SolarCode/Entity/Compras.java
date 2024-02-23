/*package com.tarea12.SolarCode.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Compras {
    @Id
    @GeneratedValue

    private int idCompra;
    private Date fechaCompra;
    private double precioTotal;

    public Compras(){

    }

    public Compras(Date fechaCompra, double precioTotal){
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
    }

}*/
package com.tarea12.SolarCode.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    private Date fechaCompra;
    private double precioTotal;

    @ManyToOne  // Añadir la relación ManyToOne aquí
    private Clientes cliente;
    @ManyToOne
    private Productos productos;
    public Compras() {
    }

    public Compras(Date fechaCompra, double precioTotal) {
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
    }
}
