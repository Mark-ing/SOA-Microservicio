package com.SOA.entidad;


import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "solicitud_cambio")
public class Solicitud_Cambio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private Integer idSolicitud;

	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

	@ManyToOne
	@JoinColumn(name = "id_jefe_area")
	private Jefe_Area jefe_area;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha_aprobacion")
	private LocalDate fechaAprobacion;

	@Column(name = "sc_estado")
	private String estado;
	
}
