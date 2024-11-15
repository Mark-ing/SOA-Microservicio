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
	//@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9\\s.,:;()/-]{3,}$\r\n",message = "{pattern.ruta_carpeta}")
    @Pattern(regexp="^[\\wáéíóúÁÉÍÓÚüÜñÑ.,:;()/-]{3,}$", message="Campo ruta_carpeta: solo letras, números, espacios y ciertos símbolos especiales (mínimo 3 caracteres)")
    private String ruta_carpeta;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modificacion;
	
	
}
