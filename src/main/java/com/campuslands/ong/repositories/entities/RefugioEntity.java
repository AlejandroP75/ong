package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "refugios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefugioEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "nombre", required = true, example = "Refugio mi casita", defaultValue = "refugio xx", description = "Nombre del refugio")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @JsonIgnoreProperties(value={"refugios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JoinColumn(name = "id_ciudad")
    @ManyToOne(fetch = FetchType.LAZY)
    private CiudadEntity ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "refugio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnvioEntity> envios;
}
