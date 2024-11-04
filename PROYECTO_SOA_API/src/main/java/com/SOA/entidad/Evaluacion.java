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
@Table(name="evaluacion")
public class Evaluacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_jefe_area")
    private Jefe_Area jefeArea;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "ev_estado")
    private String estado;

	public Integer getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Integer idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Jefe_Area getJefeArea() {
		return jefeArea;
	}

	public void setJefeArea(Jefe_Area jefeArea) {
		this.jefeArea = jefeArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
}
