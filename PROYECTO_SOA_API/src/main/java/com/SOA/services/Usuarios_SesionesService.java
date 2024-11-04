package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SOA.entidad.Usuarios_Sesiones;
import com.SOA.repository.Usuarios_SesionesRepository;

public class Usuarios_SesionesService {

	//inyeccion de dependencia
	@Autowired
	private Usuarios_SesionesRepository repo;
	
	public void registrar(Usuarios_Sesiones bean) {
		repo.save(bean);
	}
	
	public void actualizar(Usuarios_Sesiones bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Usuarios_Sesiones> listar() {
		return repo.findAll();
	}
	
	public Usuarios_Sesiones buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
