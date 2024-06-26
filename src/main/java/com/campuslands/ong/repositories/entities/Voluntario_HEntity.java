package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.List;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voluntarios_H")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voluntario_HEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_voluntario")
    @OneToOne(fetch = FetchType.LAZY)
    private VoluntarioEntity voluntario;

    @JoinColumn(name = "id_ocupacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private OcupacionEntity ocupacion;

    @Column(nullable = false)
    @NotEmpty(message = "El numero de misiones no puede ser vacio")
    @Schema(name = "numero de misiones", required = true, example = "10", defaultValue = "0", description = "Numero de misiones del voluntario humanitario")
    private int num_misiones;

    @ManyToMany(mappedBy = "voluntariosH", cascade = CascadeType.ALL)
    private List<Solicitud_HEntity> solicitudes_H;
}
