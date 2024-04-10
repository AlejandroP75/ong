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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sedes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SedeEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "direccion", required = true, example = "Carrera 24 · 35 - 30", defaultValue = "Calle xx", description = "Direccion del refugio")
    @NotEmpty(message = "La direccion no puede estar vacia")
    private String direccion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad")
    @JsonIgnore 
    private CiudadEntity ciudad;

    @JsonIgnoreProperties(value={"sedes", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JoinColumn(name = "id_director", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private UsuarioEntity director;

    @JsonIgnore
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocioEntity> socios;

    @JsonIgnore
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoluntarioEntity> voluntarios;

    @JsonIgnore
    @ManyToMany(mappedBy = "sedes", cascade = CascadeType.ALL)
    private List<EnvioEntity> envios;

}
