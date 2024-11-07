package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Usuarios;
import com.SOA.repository.UsuariosRepository;

@Service
public class UsuariosService {

	//inyeccion de dependencia
	@Autowired
	private UsuariosRepository repo;
	
	public void registrar(Usuarios bean) {
		repo.save(bean);
	}
	
	public void actualizar(Usuarios bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Usuarios> listar() {
		return repo.findAll();
	}
	
	public Usuarios buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
