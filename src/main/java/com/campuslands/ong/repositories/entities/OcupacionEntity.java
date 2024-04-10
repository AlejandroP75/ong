package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "ocupaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcupacionEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nombre no puede ser vacio")
    @Column(nullable = false)
    @Schema(name = "nombre", required = true, example = "programador", defaultValue = "conserje", description = "Nombre de la ocupacion")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "ocupacion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Voluntario_HEntity> voluntarios;

    @JsonIgnore
    @OneToMany(mappedBy = "ocupacion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Solicitud_HEntity> solicitudes;
}
