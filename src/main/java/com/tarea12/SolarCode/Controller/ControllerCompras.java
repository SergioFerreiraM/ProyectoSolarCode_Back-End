// Controller de Compras


package com.tarea12.SolarCode.Controller;

import com.tarea12.SolarCode.Entity.Compras;
import com.tarea12.SolarCode.Repositorio.RepositorioCompras;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ControllerCompras {
    private final RepositorioCompras repositorioCompras;

    public ControllerCompras(RepositorioCompras repositorioCompras){
        this.repositorioCompras = repositorioCompras;
    }
    // Obtener todas las compras
    @GetMapping
    public List<Compras> obtenerCompras(){
        return repositorioCompras.findAll();
    }
    // Agregar compras
    @PostMapping
    public Compras agregarCompras(@RequestBody Compras compras){
        return repositorioCompras.save(compras);

    }
    // Eliminar compras
    @DeleteMapping("/{id}")
    public void eliminarCompras(@PathVariable int id){
        repositorioCompras.deleteById(id);
    }
    // Actualizar compras
    @PutMapping("/{id}")
    public Compras actualizarCompras(@PathVariable int id, @RequestBody Compras compras) {
        Compras compraActualizar = repositorioCompras.findById(id).orElse(null);
        if (compraActualizar != null) {
            compraActualizar.setFechaCompra(compras.getFechaCompra());
            compraActualizar.setPrecioTotal(compras.getPrecioTotal());
            compraActualizar.setIdCompra(compras.getIdCompra());
            return repositorioCompras.save(compraActualizar);
        } else {
            return null;
        }
    }

}
