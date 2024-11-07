package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Rol_Equipo;
import com.SOA.repository.Rol_EquipoRepository;

@Service
public class Rol_EquipoService {

	//inyeccion de dependencia
	@Autowired
	private Rol_EquipoRepository repo;
	
	public void registrar(Rol_Equipo bean) {
		repo.save(bean);
	}
	
	public void actualizar(Rol_Equipo bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Rol_Equipo> listar() {
		return repo.findAll();
	}
	
	public Rol_Equipo buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
