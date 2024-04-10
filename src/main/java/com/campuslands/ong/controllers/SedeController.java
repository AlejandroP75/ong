package com.campuslands.ong.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.ong.dto.SedeDTO;
import com.campuslands.ong.repositories.entities.SedeEntity;
import com.campuslands.ong.services.SedeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sedes")
@AllArgsConstructor
public class SedeController {
    
    private SedeService sedeService;

    @GetMapping("/")
    public ResponseEntity<List<SedeDTO>> findAll() {
        return ResponseEntity.ok(sedeService.findAll());
    }

    @GetMapping("/informe")
    public ResponseEntity<List<SedeEntity>> socios() {
        return ResponseEntity.ok(sedeService.informe());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(sedeService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody SedeDTO sede){
        try{
            return ResponseEntity.ok(sedeService.save(sede));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SedeDTO sede){
        try {
            return ResponseEntity.ok(sedeService.update(id, sede));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            sedeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
