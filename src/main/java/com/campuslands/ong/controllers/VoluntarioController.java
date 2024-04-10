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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Voluntarios API", description = "Este API tiene toda la funcionalidad de los voluntarios")
@RestController
@RequestMapping("/voluntarios")
@AllArgsConstructor
public class VoluntarioController {
    
    private VoluntarioService voluntarioService;

    @Operation(description = "Retorna todos los voluntarios")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/")
    public ResponseEntity<List<VoluntarioDTO>> findAll() {
        return ResponseEntity.ok(voluntarioService.findAll());
    }

    @Operation(description = "Retorna todos los voluntarios para el informe")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/informe")
    public ResponseEntity<List<VoluntarioEntity>> socios() {
        return ResponseEntity.ok(voluntarioService.informe());
    }

    @Operation(description = "Retorna el voluntario del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(voluntarioService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @Operation(description = "Permite crear un voluntario")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody VoluntarioDTO voluntario){
        try{
            return ResponseEntity.ok(voluntarioService.save(voluntario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(description = "Borra el voluntario del id seleccionado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si sirve")})
    @ApiResponse(responseCode = "500", description = "Internal error")
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
