package com.SOA.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Solicitud_CambioDTO {

	private Integer idSolicitud;

	private int proyecto;

	private int jefe_area;

    @NotNull(message="{null.descripcion}")
	@NotBlank(message="{blank.descripcion}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.descripcion}")
	private String descripcion;

	private LocalDate fecha_aprobacion;

    @NotNull(message="{null.estado}")
	@NotBlank(message="{blank.estado}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.estado}")
	private String estado;

    private LocalDate fecha_solicitud;
	
}
