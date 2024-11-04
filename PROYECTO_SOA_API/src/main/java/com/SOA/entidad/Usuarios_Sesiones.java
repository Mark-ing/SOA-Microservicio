package com.SOA.entidad;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuarios_sesiones")
@Data
public class Usuarios_Sesiones {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Sesiones")
    private Integer IDSesiones;
	
	@ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuarios usuarios;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Ingreso")
    private LocalDate fecha_ingreso;
	
	
}
