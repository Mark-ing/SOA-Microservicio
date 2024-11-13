package com.SOA.entidad;

import java.util.List;

 
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
@Table(name="jefe_area")
@Data
public class Jefe_Area {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JefeArea")
    private Integer IDJefeArea;

    @ManyToOne	
    @JoinColumn(name = "ID_Usuario")
    private Usuarios usuario;
    
    @Column(name = "JF_Nombre")
    private String nombre;

    @Column(name = "JF_Apellido")
    private String apellido;
	
    
    
    @OneToMany(mappedBy = "jefe_area")
    @JsonIgnore
    private List<Asignacion_Proyecto> asignacion_proyecto;
    
    @OneToMany(mappedBy = "jefe_area")
    @JsonIgnore
    private List<Solicitud_Cambio> solicitud_cambio;
    
    @OneToMany(mappedBy = "jefe_area")
    @JsonIgnore
    private List<Aprobacion> aprobacion;
 
}	
