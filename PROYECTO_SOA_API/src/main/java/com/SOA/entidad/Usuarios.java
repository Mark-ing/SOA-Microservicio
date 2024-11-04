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
@Table(name="usuarios")
@Data
public class Usuarios {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private Integer IDUsuario;

    @ManyToOne
    @JoinColumn(name = "ID_Rol")
    private Rol_Usuarios rol; // Relación con Rol

    @ManyToOne
    @JoinColumn(name = "ID_Area")
    private Area area; // Relación con Area

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Creacion")
    private LocalDate fechaCreacion;

    @Column(name = "U_Estado")	
    private String estado;
    //------------------------------------------
    //asociacion con las otras tablas
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Jefe_Area> jefesArea;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Empleado> empleados;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Usuarios_Sesiones> usuarios_sesiones;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Jefe_Proyecto> jefes_proyecto;
}
