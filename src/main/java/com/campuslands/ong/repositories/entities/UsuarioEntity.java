package com.campuslands.ong.repositories.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Schema(name = "nombre", required = true, example = "Alejandro", defaultValue = "Pedro", description = "Nombre del usuario a registrar")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(nullable = false)
    @Schema(name = "apellido", required = true, example = "Palacio", defaultValue = "Muñoz", description = "Apellido del usuario a registrar")
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @Column(nullable = false, unique = true)
    @Schema(name = "email", required = true, example = "example@mail.com", defaultValue = "example@mail.com", description = "Email del usuario a registrar")
    @NotEmpty(message = "El email no es valido")
    private String email;

    @Column(nullable = false)
    @Schema(name = "telefono", required = true, example = "123456789", defaultValue = "0000000000", description = "Telefono del usuario a registrar")
    @NotEmpty(message = "El telefono no puede estar vacio")
    private String telefono;

    @Column(nullable = false, unique = true)
    @Schema(name = "cedula", required = true, example = "123456789", defaultValue = "000000000", description = "Numero de cedula del usuario a resgistar")
    @NotEmpty(message = "La cedula no puede estar vacio o ya existe esa cedula")
    private String cedula;

    @Column(nullable = false)
    @Schema(name = "contraseña", required = true, example = "********", defaultValue = "********", description = "Contraseña del usuario a registrar")
    @NotEmpty(message = "La contraseña no puede estar vacia")
    private String contraseña;

    @Column(nullable = false)
    @Schema(name = "tipo de rol", required = true, example = "0", defaultValue = "0", description = "Rol del usuario a resgistrar, hay 3 roles, 0 para administrador, 1 para director, 2 para auxiliar")
    @NotEmpty(message = "El rol no puede estar vacio")
    @Enumerated(EnumType.ORDINAL)
    private Tipo_RolEnum tipo_rol;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private VoluntarioEntity voluntario;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SocioEntity socio;

    @JsonIgnore
    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SedeEntity director;



}
