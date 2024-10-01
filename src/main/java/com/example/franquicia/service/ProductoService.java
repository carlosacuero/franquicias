package com.example.franquicia.service;

import com.example.franquicia.modelos.Producto;
import com.example.franquicia.modelos.Sucursal;
import com.example.franquicia.repository.ProductoRepository;
import com.example.franquicia.repository.SucursalRepository;
import com.example.franquicia.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Producto agregarProducto(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow(() -> new ResourceNotFoundException("Sucursal no encontrada"));
        sucursal.getProductos().add(producto);
        sucursalRepository.save(sucursal);
        return producto;
    }

    public void eliminarProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto modificarStock(Long productoId, int nuevoStock) {
        Producto producto = productoRepository.findById(productoId).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerProductoConMasStock(Long franquiciaId) {
        // Implementación para obtener el producto con más stock por sucursal
        // Aquí podrías usar una consulta personalizada o lógica de negocio para obtener los datos
        // Ejemplo simplificado:
        return productoRepository.findProductosConMasStockPorFranquicia(franquiciaId);
    }

    public Producto actualizarNombreProducto(Long productoId, String nuevoNombre) {
        Producto producto = productoRepository.findById(productoId).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        producto.setNombre(nuevoNombre);
        return productoRepository.save(producto);
    }
}