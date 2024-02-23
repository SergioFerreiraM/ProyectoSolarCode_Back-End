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
public class Categoria {
    @Id
    @GeneratedValue

    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private int SKU;

    @OneToMany(mappedBy = "Categorias")
    private List<Productos> productos = new ArrayList<>();
    public Categoria(){

    }
    public Categoria(String nombreCategoria, List<Productos> productos, String descripcion, int SKU){
        this.nombreCategoria = nombreCategoria;
        this.productos = productos;
        this.descripcion = descripcion;
        this.SKU = SKU;
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
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String SKU;


    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Productos> productos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(String nombreCategoria, String descripcion, String SKU) {
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.SKU = SKU;
    }
}
