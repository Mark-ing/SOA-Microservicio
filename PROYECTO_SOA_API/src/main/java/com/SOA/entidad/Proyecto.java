package com.SOA.entidad;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="proyecto")
@Data

public class Proyecto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Proyecto")
    private Integer idProyecto;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo")
    private Equipo idEquipo;
    
    @ManyToOne
    @JoinColumn(name = "ID_Equipo")
    private Jefe_Proyecto idJefePro;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @Column(name = "Descripcion")
    private String descripcion;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Fin")
    private LocalDate fechaFin;

    @Column(name = "P_Estado")
    private String estado;

    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private List<Documento> documento;

    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private List<Evaluacion> asignacionproyecto;

    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private List<Aprobacion> aprobaciones;

    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private List<Solicitud_Cambio> solicitudesCambio;

	
}
