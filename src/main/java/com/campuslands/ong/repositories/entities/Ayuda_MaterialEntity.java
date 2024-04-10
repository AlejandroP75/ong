package com.campuslands.ong.repositories.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ayudas_materiales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ayuda_MaterialEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "La cantidad no puede estar vacia")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_envio")
    private EnvioEntity envio;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;
}
