package com.SOA.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DocumentoDTO {

    private Integer idDocumento;

    private ProyectoDTO proyecto;

    @NotNull(message="{null.ruta_carpeta}")
	@NotBlank(message="{blank.ruta_carpeta}")
	@Pattern(regexp="^[a-zA-Z0-9_\\\\/-]+(\\\\[a-zA-Z0-9_\\\\/-]+)*$\r\n",message = "{pattern.ruta_carpeta}")
    private String ruta_carpeta;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modificacion;
	
	
}
