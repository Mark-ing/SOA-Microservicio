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
    private Integer IDProyecto;

    @Column(name = "ID_Equipo")
    private int equipo;
    
    @Column(name = "Nombre_Proyecto")
    private String nombre_proyecto;

    @Column(name = "Descripcion")
    private String descripcion;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Inicio")
    private LocalDate fecha_inicio;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Fin")
    private LocalDate fecha_fin;

    @Column(name = "P_Estado")
    private String estado;

    @Column(name = "ID_JefePro")
    private int jefe_proyecto;

    
    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private List<Documento> documento;

    

    

	
}
