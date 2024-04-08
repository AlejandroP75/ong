package com.campuslands.ong.repositories.entities;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitudes_h")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud_HEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "La cantidad no puede estar vacia")
    private int cantidad;

    @ManyToOne()
    @JoinColumn(name = "id_envio")
    private EnvioEntity envio;

    @ManyToOne()
    @JoinColumn(name = "id_ocupacion")
    private OcupacionEntity ocupacion;
    
    @ManyToMany
    @JoinTable(name = "solicitud_voluntarioH", joinColumns = @JoinColumn(name = "id_solicitud"), inverseJoinColumns = @JoinColumn(name = "id_voluntario_H"))
    private List<Voluntario_HEntity> voluntariosH;
}
