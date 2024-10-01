package com.example.franquicia.repository;


import com.example.franquicia.modelos.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    // Ejemplo de consulta personalizada para encontrar sucursales por nombre
    //@Query("SELECT s FROM Sucursal s WHERE s.nombre = :nombre")
    List<Sucursal> findByNombre(@Param("nombre") String nombre);
}
