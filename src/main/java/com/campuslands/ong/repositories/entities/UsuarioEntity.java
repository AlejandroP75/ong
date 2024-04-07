package com.campuslands.ong.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @JoinColumn(name = "id_rol")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipo_RolEntity tipo_rol;

}
