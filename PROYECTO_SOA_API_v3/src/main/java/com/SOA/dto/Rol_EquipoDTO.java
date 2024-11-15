package com.SOA.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Rol_EquipoDTO {

    private Integer idrolEquipo;
	
    @NotNull(message="{null.descripcion}")
	@NotBlank(message="{blank.descripcion}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.descripcion}")
    private String descripcion;
	
    private LocalDate fechaCreacion;

}
