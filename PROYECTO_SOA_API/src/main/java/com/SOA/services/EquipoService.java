package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SOA.entidad.Equipo;
import com.SOA.repository.EquipoRepository;

public class EquipoService {
	
	//inyeccion de dependencia
	@Autowired
	private EquipoRepository repo;
	
	public void registrar(Equipo bean) {
		repo.save(bean);
	}
	
	public void actualizar(Equipo bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Equipo> listar() {
		return repo.findAll();
	}
	
	public Equipo buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
