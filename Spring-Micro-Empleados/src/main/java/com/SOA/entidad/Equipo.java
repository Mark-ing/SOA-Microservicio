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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "equipo")
@Data
public class Equipo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Equipo")
    private Integer idEquipo;

	@Column(name = "Nombre_Equipo")
    private String nombre_equipo;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Creacion")
    private LocalDate fechaCreacion;

    @Column(name = "Estado_Equipo")
    private String estadoEquipo;

    


    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Equipo_Empleado> equipos_empleados;
    
	/*
	 * @ManyToMany(mappedBy = "equipo")
	 * 
	 * @JsonIgnore private List<Empleado> empleados;
	 */
   
}
