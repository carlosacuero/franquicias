package com.example.franquicia.controller;

import com.example.franquicia.modelos.Producto;
import com.example.franquicia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Endpoint para agregar un nuevo producto a una sucursal
    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<Producto> agregarProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        Producto nuevoProducto = productoService.agregarProducto(sucursalId, producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un producto de una sucursal
    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long productoId) {
        productoService.eliminarProducto(productoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para modificar el stock de un producto
    @PutMapping("/{productoId}/stock")
    public ResponseEntity<Producto> modificarStock(@PathVariable Long productoId, @RequestBody int nuevoStock) {
        Producto productoActualizado = productoService.modificarStock(productoId, nuevoStock);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }


   @GetMapping("/franquicia/{franquiciaId}/max-stock")
   public ResponseEntity<List<Producto>> obtenerProductoConMasStock(@PathVariable Long franquiciaId) {
       List<Producto> productos = productoService.obtenerProductoConMasStock(franquiciaId);
       return new ResponseEntity<>(productos, HttpStatus.OK);
   }


    // Endpoint para actualizar el nombre de un producto (punto extra)
    @PutMapping("/{productoId}/nombre")
    public ResponseEntity<Producto> actualizarNombreProducto(@PathVariable Long productoId, @RequestBody String nuevoNombre) {
        Producto productoActualizado = productoService.actualizarNombreProducto(productoId, nuevoNombre);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

}
