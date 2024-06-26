package com.campuslands.ong.repositories.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voluntarios")
public class VoluntarioEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(value={"voluntarios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JoinColumn(name = "id_sede")
    @ManyToOne()
    private SedeEntity sede;

    @JsonIgnoreProperties(value={"voluntarios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JoinColumn(name = "id_usuario")
    @OneToOne(fetch = FetchType.LAZY)
    private UsuarioEntity usuario;

    @JsonIgnore
    @OneToOne(mappedBy = "voluntario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Voluntario_HEntity voluntario_H;
}
