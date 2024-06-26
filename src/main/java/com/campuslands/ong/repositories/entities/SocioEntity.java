package com.campuslands.ong.repositories.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "fecha_pago", required = true, example = "yyyy/mm/dd", defaultValue = "yyyy/mm/dd", description = "Fecha de pago de la cuota anual")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_pago;

    @Column(nullable = false)
    @Schema(name = "numero de cuenta", required = true, example = "123456789", defaultValue = "xxxxxxxxx", description = "Numero de cuenta del socio")
    @NotEmpty(message = "El numero de cuenta no puede estar vacio")
    private String numero_cuenta;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipoCuota")
    private TipoCuotaEntity tipoCuota;

    @ManyToOne
    @JoinColumn(name = "id_sede")
    private SedeEntity sede;
}
