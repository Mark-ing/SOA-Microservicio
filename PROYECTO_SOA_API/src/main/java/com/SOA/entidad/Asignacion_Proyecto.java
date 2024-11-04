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
public class Asignacion_Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Aprobacion")
	private Integer idAprobacion;

	@ManyToOne	
    @JoinColumn(name = "ID_Proyecto")
    private Proyecto proyecto;
	
	@ManyToOne	
    @JoinColumn(name = "ID_JefeArea")
    private Jefe_Area jefe_area;


}
