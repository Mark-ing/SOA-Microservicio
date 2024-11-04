package com.SOA.entidad;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rol_equipo")
@Data
public class Rol_Equipo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rol_Equipo")
    private Integer idrolEquipo;
	
	@Column(name = "Descripcion")
    private String descripcion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Creacion", nullable = false)
    private LocalDate fechaCreacion;
	//------------------------------------------
    //asociacion con las otras tablas
	
    @ManyToAny
    @JoinTable(
    		name = "equipo_empleado",
    		joinColumns = @JoinColumn(
    				name = "ID_Rol_Equipo",
    				referencedColumnName = "idrolEquipo"),
    		inverseJoinColumns = @JoinColumn(
    				name = "ID_Equipo",
    	    		referencedColumnName = "idEquipo")
    		)
    @JsonIgnore
    private List<Equipo> equipos;
    
}
