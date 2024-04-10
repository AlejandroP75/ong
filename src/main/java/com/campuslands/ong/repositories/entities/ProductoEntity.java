package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "nombre", required = true, example = "Manzana", defaultValue = "manzana", description = "Nombre del producto")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    
    @NotEmpty(message = "El tipo de producto no puede estar vacio")
    @Column(nullable = false)
    @Schema(name = "tipo", required = true, example = "0", defaultValue = "0", description = "Tipo de producto 0 para alimentos y 1 para medicamentos ")
    @Enumerated(EnumType.ORDINAL)
    private Tipo_ProductoEnum tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ayuda_MaterialEntity> ayudas_materiales;

}
