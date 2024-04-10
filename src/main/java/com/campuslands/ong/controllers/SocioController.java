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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Socios API", description = "Este API tiene toda la funcionalidad de los socios")
@RestController
@RequestMapping("/socios")
@AllArgsConstructor
public class SocioController {
    
    private SocioService socioService;

    @Operation(description = "Retorna todos los socios")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/")
    public ResponseEntity<List<SocioDTO>> findAll() {
        return ResponseEntity.ok(socioService.findAll());
    }

    @Operation(description = "Retorna todos los socios para el informe")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/informe")
    public ResponseEntity<List<SocioEntity>> socios() {
        return ResponseEntity.ok(socioService.informe());
    }

    @Operation(description = "Retorna el socio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(socioService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @Operation(description = "Permite crear un socio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody SocioDTO socio){
        try{
            return ResponseEntity.ok(socioService.save(socio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Permite actualizar un socio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SocioDTO socio){
        try {
            return ResponseEntity.ok(socioService.update(id, socio));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Borra el socio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
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
