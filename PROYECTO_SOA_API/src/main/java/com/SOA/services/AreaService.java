package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Area;
import com.SOA.repository.AreaRepository;

@Service
public class AreaService {

	//inyeccion de dependencia
	@Autowired
	private AreaRepository repo;
	
	public void registrar(Area bean) {
		repo.save(bean);
	}
	
	public void actualizar(Area bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Area> listar() {
		return repo.findAll();
	}
	
	public Area buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
