package com.SOA.entidad;


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
@Table(name = "equipo_empleado")
@Data
public class Equipo_Empleado {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Equipo_Empleado")
    private Integer IDEquipo_Empleado;
	
	 @ManyToOne
	 @JoinColumn(name = "ID_Equipo")
	 private Equipo equipo;
	 
	 @ManyToOne
	 @JoinColumn(name = "ID_Empleado")
	 private Empleado empleado;
}
