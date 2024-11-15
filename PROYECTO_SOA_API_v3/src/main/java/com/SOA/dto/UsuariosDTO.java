package com.SOA.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsuariosDTO {

    private Integer IDUsuario;

    private Rol_UsuariosDTO rol_usuarios; // Relación con Rol

    private AreaDTO area; // Relación con Area

    @NotNull(message="{null.correo}")
	@NotBlank(message="{blank.correo}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.correo}")
    private String correo;

    @NotNull(message="{null.contrasena}")
	@NotBlank(message="{blank.contrasena}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.contrasena}")
    private String contrasena;
 
    private LocalDate fechaCreacion;

    @NotNull(message="{null.estado}")
	@NotBlank(message="{blank.estado}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.estado}")
    private String estado;

}