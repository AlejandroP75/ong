package com.campuslands.ong.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EnvioDTO {
    
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    private List<Long> solicitudIds;

    private Long refugioId;

    private List<Long> ayudaMaterialIds;

    private List<Long> sedesIds;
}
