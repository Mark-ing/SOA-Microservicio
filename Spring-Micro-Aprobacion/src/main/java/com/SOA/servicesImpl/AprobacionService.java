package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Aprobacion;
import com.SOA.repository.AprobacionRepository;

@Service
public class AprobacionService extends ICRUDImpl<Aprobacion, Integer>{

	@Autowired
	private AprobacionRepository repo;
	
	@Override
	public JpaRepository<Aprobacion, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
