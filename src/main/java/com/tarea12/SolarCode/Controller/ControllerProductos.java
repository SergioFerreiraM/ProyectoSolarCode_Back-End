package com.tarea12.SolarCode.Controller;

import com.tarea12.SolarCode.Entity.Productos;
import com.tarea12.SolarCode.Repositorio.RepositorioProductos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/productos")
public class ControllerProductos {
    private final RepositorioProductos repositorioProductos;
    public ControllerProductos(RepositorioProductos repositorioProductos){
        this.repositorioProductos = repositorioProductos;
    }
    @GetMapping
    public List<Productos> obtenerProductos(){
        return repositorioProductos.findAll();
    }
    @PostMapping
    public Productos agregarProducto(@RequestBody Productos productos){
        return repositorioProductos.save(productos);
    }
    @GetMapping("/{id}")
    public Productos encontrarProducto(@PathVariable int id){
        return repositorioProductos.findById(id).get();
    }
    // Eliminar productos
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id){
        repositorioProductos.deleteById(id);
    }
    // Actualizar productos de acuerdo al id
    @PutMapping("/{id}")
    public Productos actualizarProductos(@PathVariable int id,@RequestBody Productos productos) {
        Productos productoActualizar = repositorioProductos.findById(id).orElse(null);
        if (productoActualizar != null) {
            productoActualizar.setNombre(productos.getNombre());
            productoActualizar.setPrecio(productos.getPrecio());
            productoActualizar.setMarca(productos.getMarca());
            productoActualizar.setDescripcion(productos.getDescripcion());
            productoActualizar.setFichaTecnica(productos.getFichaTecnica());
            productoActualizar.setSKU(productos.getSKU());
            productoActualizar.setStock(productos.getStock());
            return repositorioProductos.save(productoActualizar);
        } else {
            return null;
        }
    }
}

//https://documenter.getpostman.com/view/33090298/2sA2rCU1z4