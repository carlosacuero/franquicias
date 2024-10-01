package com.example.franquicia.controller;

import com.example.franquicia.exception.ResourceNotFoundException;
import com.example.franquicia.modelos.Franquicia;
import com.example.franquicia.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @GetMapping
    public List<Franquicia> getAllFranquicias() {
        return franquiciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franquicia> getFranquiciaById(@PathVariable Long id) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada con id: " + id));
        return ResponseEntity.ok(franquicia);
    }

    @PostMapping
    public Franquicia createFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franquicia> updateFranquicia(@PathVariable Long id, @RequestBody Franquicia franquiciaDetails) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada con id: " + id));

        franquicia.setNombre(franquiciaDetails.getNombre());

        Franquicia updatedFranquicia = franquiciaRepository.save(franquicia);
        return ResponseEntity.ok(updatedFranquicia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranquicia(@PathVariable Long id) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada con id: " + id));

        franquiciaRepository.delete(franquicia);
        return ResponseEntity.noContent().build();
    }
}
