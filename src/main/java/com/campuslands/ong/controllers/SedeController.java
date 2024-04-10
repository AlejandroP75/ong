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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Sedes API", description = "Este API tiene toda la funcionalidad de las sedes")
@RestController
@RequestMapping("/sedes")
@AllArgsConstructor
public class SedeController {
    
    private SedeService sedeService;

    @Operation(description = "Retorna todos los servicios")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/")
    public ResponseEntity<List<SedeDTO>> findAll() {
        return ResponseEntity.ok(sedeService.findAll());
    }

    @Operation(description = "Retorna todos los servicios para el informe")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/informe")
    public ResponseEntity<List<SedeEntity>> socios() {
        return ResponseEntity.ok(sedeService.informe());
    }

    @Operation(description = "Retorna el servicio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(sedeService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @Operation(description = "Permite crear un servicio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody SedeDTO sede){
        try{
            return ResponseEntity.ok(sedeService.save(sede));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Permite actualizar un servicio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SedeDTO sede){
        try {
            return ResponseEntity.ok(sedeService.update(id, sede));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Borra el servicio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
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
