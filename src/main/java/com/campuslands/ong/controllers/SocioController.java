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

import com.campuslands.ong.dto.SocioDTO;
import com.campuslands.ong.repositories.entities.SocioEntity;
import com.campuslands.ong.services.SocioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/socios")
@AllArgsConstructor
public class SocioController {
    
    private SocioService socioService;

    @GetMapping("/")
    public ResponseEntity<List<SocioDTO>> findAll() {
        return ResponseEntity.ok(socioService.findAll());
    }

    @GetMapping("/informe")
    public ResponseEntity<List<SocioEntity>> socios() {
        return ResponseEntity.ok(socioService.informe());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(socioService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody SocioDTO socio){
        try{
            return ResponseEntity.ok(socioService.save(socio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SocioDTO socio){
        try {
            return ResponseEntity.ok(socioService.update(id, socio));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            socioService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
