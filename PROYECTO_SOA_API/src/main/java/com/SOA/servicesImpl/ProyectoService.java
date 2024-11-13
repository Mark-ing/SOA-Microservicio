package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SOA.entidad.Proyecto;
import com.SOA.repository.ProyectoRepository;

public class ProyectoService extends ICRUDImpl<Proyecto, Integer>{

	@Autowired
	private ProyectoRepository repo;

	@Override
	public JpaRepository<Proyecto, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
