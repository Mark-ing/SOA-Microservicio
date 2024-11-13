package com.SOA.entidad;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="documento")
@Data
public class Documento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Documento")
    private Integer idDocumento;

    @ManyToOne
    @JoinColumn(name = "ID_Proyecto")
    private Proyecto proyecto;

    @Column(name = "Ruta_Carpeta")
    private String ruta_carpeta;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Creacion")
    private LocalDate fecha_creacion;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha_Modificacion")
    private LocalDate fecha_modificacion;
	
	
}
