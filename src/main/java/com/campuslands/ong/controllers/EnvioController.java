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

import com.campuslands.ong.dto.EnvioDTO;
import com.campuslands.ong.repositories.entities.EnvioEntity;
import com.campuslands.ong.services.EnvioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Envios API", description = "Este API tiene toda la funcionalidad de los envios")
@RestController
@RequestMapping("/envios")
@AllArgsConstructor
public class EnvioController {
    
    private EnvioService envioService;

    @Operation(description = "Retorna todos los envios")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/")
    public ResponseEntity<List<EnvioDTO>> findAll() {
        return ResponseEntity.ok(envioService.findAll());
    }

    @Operation(description = "Retorna todos los envios para el informe")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/informe")
    public ResponseEntity<List<EnvioEntity>> socios() {
        return ResponseEntity.ok(envioService.informe());
    }

    @Operation(description = "Retorna el envio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(envioService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @Operation(description = "Permite crear un envio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody EnvioDTO envio){
        try{
            return ResponseEntity.ok(envioService.save(envio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Permite actualizar un envio")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EnvioDTO envio){
        try {
            return ResponseEntity.ok(envioService.update(id, envio));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Borra el envio del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            envioService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
