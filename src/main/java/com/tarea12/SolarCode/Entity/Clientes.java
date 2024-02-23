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
public class Clientes {
    @Id
    @GeneratedValue
    private int idClientes;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;

    @OneToMany(mappedBy = "Clientes")
    private List<Compras> idCompra = new ArrayList<>();
    public Clientes(){

    }
    public Clientes(String nombre, List<Compras> idCompra,String apellido, String telefono, String direccion, String correo){
        this.nombre = nombre;
        this.idCompra = idCompra;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
}*/
package com.tarea12.SolarCode.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClientes;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;

    @OneToMany(mappedBy = "cliente")  // Corregir el nombre aquí
    private List<Compras> idCompra = new ArrayList<>();

    public Clientes() {
    }

    public Clientes(String nombre, List<Compras> idCompra, String apellido, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.idCompra = idCompra;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
}
