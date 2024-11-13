package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Jefe_Area;
import com.SOA.repository.Jefe_AreaRepository;

@Service
public class Jefe_AreaService extends ICRUDImpl<Jefe_Area, Integer>{

	@Autowired
	private Jefe_AreaRepository repo;

	@Override
	public JpaRepository<Jefe_Area, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
