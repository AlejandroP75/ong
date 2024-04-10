package com.campuslands.ong.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.ong.dto.VoluntarioDTO;
import com.campuslands.ong.repositories.entities.VoluntarioEntity;
import com.campuslands.ong.services.VoluntarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/voluntarios")
@AllArgsConstructor
public class VoluntarioController {
    
    private VoluntarioService voluntarioService;

    @GetMapping("/")
    public ResponseEntity<List<VoluntarioDTO>> findAll() {
        return ResponseEntity.ok(voluntarioService.findAll());
    }

    @GetMapping("/informe")
    public ResponseEntity<List<VoluntarioEntity>> socios() {
        return ResponseEntity.ok(voluntarioService.informe());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(voluntarioService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody VoluntarioDTO voluntario){
        try{
            return ResponseEntity.ok(voluntarioService.save(voluntario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            voluntarioService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
