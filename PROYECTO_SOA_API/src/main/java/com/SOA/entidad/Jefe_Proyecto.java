package com.SOA.entidad;

import java.time.LocalDate;
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
@Table(name="jefe_proyecto")
@Data
public class Jefe_Proyecto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_JefePro")
    private Integer idJefePro;

	@Column(name = "JP_Nombre")
    private String nombre;
    
	@Column(name = "JP_Apellido")
    private String apellido;
	
	@ManyToOne
    @JoinColumn(name = "ID_Usuarios")
    private Usuarios usuario;
	
	@OneToMany(mappedBy = "jefe_proyecto")
    @JsonIgnore
    private List<Proyecto> proyecto;
}
