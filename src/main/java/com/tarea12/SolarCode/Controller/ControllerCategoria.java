package com.tarea12.SolarCode.Controller;
// controlador de categorias

import com.tarea12.SolarCode.Entity.Categoria;
import com.tarea12.SolarCode.Repositorio.RepositorioCategoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class ControllerCategoria {

    private final RepositorioCategoria repositorioCategoria;

    public ControllerCategoria(RepositorioCategoria repositorioCategoria){
        this.repositorioCategoria = repositorioCategoria;
    }

    // obtener todas las categorias
    @GetMapping
    public List<Categoria> obtenerTodasCategorias(){
        return repositorioCategoria.findAll();
    }

    // obtener una categoria
    @GetMapping("/{id}")
    public Categoria obtenerUnaCategoria(@PathVariable int id){
        return repositorioCategoria.findById(id).get();
    }
    // eliminar una categoria
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable int id){
        repositorioCategoria.deleteById(id);
    }
    // agregar una categoria
    @PostMapping
    public Categoria agregarCategoria(@RequestBody Categoria categoria){
        return repositorioCategoria.save(categoria);
    }
    // actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable int id, @RequestBody Categoria categoriaActualizada) {
        Optional<Categoria> optionalCategoria = repositorioCategoria.findById(id);

        if (optionalCategoria.isPresent()) {
            Categoria categoriaExistente = optionalCategoria.get();
            categoriaExistente.setNombreCategoria(categoriaActualizada.getNombreCategoria());
            categoriaExistente.setProductos(categoriaActualizada.getProductos());
            categoriaExistente.setDescripcion(categoriaActualizada.getDescripcion());
            categoriaExistente.setSKU(categoriaActualizada.getSKU());

            Categoria categoriaActualizadaEnBD = repositorioCategoria.save(categoriaExistente);
            return ResponseEntity.ok(categoriaActualizadaEnBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
