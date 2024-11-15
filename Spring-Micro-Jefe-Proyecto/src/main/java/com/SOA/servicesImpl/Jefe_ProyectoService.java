package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Jefe_Proyecto;
import com.SOA.repository.Jefe_ProyectoRepository;

@Service
public class Jefe_ProyectoService extends ICRUDImpl<Jefe_Proyecto, Integer>{

	@Autowired
	private Jefe_ProyectoRepository repo;

	@Override
	public JpaRepository<Jefe_Proyecto, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
