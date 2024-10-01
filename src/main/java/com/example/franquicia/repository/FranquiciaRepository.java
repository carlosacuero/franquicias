package com.example.franquicia.repository;

import com.example.franquicia.modelos.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
