package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Equipo;
import com.SOA.repository.EquipoRepository;

@Service
public class EquipoService extends ICRUDImpl<Equipo, Integer>{
	
	//inyeccion de dependencia
	@Autowired
	private EquipoRepository repo;

	@Override
	public JpaRepository<Equipo, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
