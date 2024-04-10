package com.campuslands.ong.repositories.entities;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tipos_cuotas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCuotaEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "nombre", required = true, example = "minima", defaultValue = "minima", description = "Nombre de la cuota a definir")
    @NotEmpty(message = "El nombre de la cuota no puede ser vacio")
    private String nombre;

    @Column(nullable = false)
    @Schema(name = "precio", required = true, example = "10.0", defaultValue = "0.0", description = "Precio de la cuota a definir")
    @NotEmpty(message = "El precio de la cuota no puede ser vacio")
    private Float precio;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoCuota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocioEntity> socios;
}
