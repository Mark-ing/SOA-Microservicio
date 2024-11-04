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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="area")
@Data
public class Area {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Area")
    private Integer idArea;

    @Column(name = "Nombre")
    private String nombre;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Creacion", nullable = false)
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private List<Usuarios> usuarios;

	
	
	
}
