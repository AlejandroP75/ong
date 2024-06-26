package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha_inicio")
    @Schema(name = "fecha inicio", required = true, example = "yyyy/mm/dd", defaultValue = "yyyy/mm/dd", description = "Fecha de inicio del envio")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @JsonIgnore
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud_HEntity> solicitud;

    @JsonIgnoreProperties(value={"envios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne()
    @JoinColumn(name = "id_refugio")
    private RefugioEntity refugio;

    @JsonIgnore
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ayuda_MaterialEntity> ayuda_material;

    @JsonIgnoreProperties(value={"envios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToMany
    @JoinTable(name = "envios_sedes", joinColumns = @JoinColumn(name = "id_envio"), inverseJoinColumns = @JoinColumn(name = "id_sede"))
    private List<SedeEntity> sedes;
    
}
