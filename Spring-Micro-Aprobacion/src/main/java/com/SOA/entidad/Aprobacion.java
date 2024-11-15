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
@Table(name = "aprobacion")
@Data
public class Aprobacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Aprobacion")
	private Integer IDAprobacion;
	
    @Column(name = "ID_Proyecto")
    private int proyecto;
	
    @Column(name = "ID_JefeArea")
    private int jefe_area;
	
	@Column(name = "Descripcion")
    private String descripcion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "Fecha_Aprobacion")
    private LocalDate fecha_aprobacion;
	
	@Column(name = "Ap_estado")
    private String estado;

}
