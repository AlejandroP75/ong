package com.campuslands.ong.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @Column(nullable = false, unique = true)
    @Email(message = "El email no es valido")
    private Email email;

    @Column(nullable = false)
    @NotEmpty(message = "El telefono no puede estar vacio")
    private String telefono;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "La cedula no puede estar vacio o ya existe esa cedula")
    private String cedula;

    @Column(nullable = false)
    @NotEmpty(message = "La contraseña no puede estar vacia")
    private String contraseña;

    @Column(nullable = false)
    @NotEmpty(message = "El rol no puede estar vacio")
    @Enumerated(EnumType.ORDINAL)
    private Tipo_RolEnum tipo_rol;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private VoluntarioEntity voluntario;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SocioEntity socio;

    @JsonIgnore
    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SedeEntity director;



}
