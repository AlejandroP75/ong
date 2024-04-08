package com.campuslands.ong.repositories.entities;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "tipos_couta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo_CuotaEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la cuota no puede ser vacio")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "El precio de la cuota no puede ser vacio")
    private Float precio;

    @JsonIgnore
    @OneToMany(mappedBy = "quotaType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocioEntity> socios;
}
