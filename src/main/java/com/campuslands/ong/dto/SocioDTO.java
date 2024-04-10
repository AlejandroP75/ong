package com.campuslands.ong.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SocioDTO {
    
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaPago;

    private String numeroCuenta;

    private Long usuarioId;

    private Long tipoCuotaId;

    private Long sedeId;
}
