package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Rol_Usuarios;
import com.SOA.repository.Rol_UsuariosRepository;

@Service
public class Rol_UsuariosService {

	//inyeccion de dependencia
	@Autowired
	private Rol_UsuariosRepository repo;
	
	public void registrar(Rol_Usuarios bean) {
		repo.save(bean);
	}
	
	public void actualizar(Rol_Usuarios bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Rol_Usuarios> listar() {
		return repo.findAll();
	}
	
	public Rol_Usuarios buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
