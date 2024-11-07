package com.SOA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Empleado;
import com.SOA.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	//inyeccion de dependencia
	@Autowired
	private EmpleadoRepository repo;
	
	public void registrar(Empleado bean) {
		repo.save(bean);
	}
	
	public void actualizar(Empleado bean) {
		repo.save(bean);
	}
	
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Empleado> listar() {
		return repo.findAll();
	}
	
	public Empleado buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
