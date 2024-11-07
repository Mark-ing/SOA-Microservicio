package com.SOA.entidad;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="empleado")
@Data
public class Empleado {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empleado")
    private Integer idEmpleado;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuarios usuario;

    @Column(name = "E_Nombre")
    private String nombre;

    @Column(name = "E_Apellido")
    private String apellido;
    
    @ManyToOne
    @JoinColumn(name = "ID_Rol_Equipo")
    private Rol_Equipo rol_equipo;
    //------------------------------------------
    //asociacion con las otras tablas
    
    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<Equipo_Empleado> equipos_empleados;
    
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "equipo_empleado", joinColumns = @JoinColumn( name =
	 * "ID_Equipo", referencedColumnName = "idEquipo"), inverseJoinColumns
	 * = @JoinColumn( name = "ID_Empleado", referencedColumnName = "idEmpleado") )
	 * 
	 * @JsonIgnore private List<Equipo> equipos;
	 */
}