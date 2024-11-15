package com.SOA.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AreaDTO {

    private Integer idArea;

    @NotNull(message = "{null.nombre}")
	@NotBlank(message="{blank.nombre}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.nombre}")
    private String nombre;

    private LocalDate fechaCreacion;

}
