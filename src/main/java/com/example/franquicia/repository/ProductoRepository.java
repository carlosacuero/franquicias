package com.example.franquicia.repository;

import com.example.franquicia.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta personalizada para obtener el producto con más stock por sucursal para una franquicia específica
    @Query("SELECT p FROM Producto p WHERE p.franquicia.id = :franquiciaId ORDER BY p.stock DESC")
    List<Producto> findProductosConMasStockPorFranquicia(@Param("franquiciaId") Long franquiciaId);
}

