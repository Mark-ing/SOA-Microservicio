package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Area;
import com.SOA.repository.AreaRepository;
import com.SOA.services.ICRUD;

@Service
public class AreaService extends ICRUDImpl<Area, Integer>{

	//inyeccion de dependencia
	@Autowired
	private AreaRepository repo;

	@Override
	public JpaRepository<Area, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
