/*package com.tarea12.SolarCode.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Productos {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private double precio;
    private String marca;
    private String descripcion;
    private String fichaTecnica;
    private int SKU;
    private int stock;





    @OneToMany(mappedBy = "Productos")
    private List<Compras> idCompra = new ArrayList<>();
    private Categoria categoria;
    public Productos(){

    }
    public Productos(String nombre, List<Compras> idCompra,double precio, String marca, String descripcion, String fichaTecnica, int SKU, int stock){
        this.nombre = nombre;
        this.idCompra = idCompra;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.fichaTecnica = fichaTecnica;
        this.SKU = SKU;
        this.stock = stock;
    }


}*/
package com.tarea12.SolarCode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;
    private String marca;
    @Column(length = 2000)
    private String descripcion;
    private String fichaTecnica;
    private String SKU;
    private int stock;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "productos")
    @JsonIgnore
    private List<Compras> compras = new ArrayList<>();
    public Productos() {
    }

    public Productos(String nombre, double precio, String marca, String descripcion, String fichaTecnica, String SKU, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.fichaTecnica = fichaTecnica;
        this.SKU = SKU;
        this.stock = stock;
    }
}


