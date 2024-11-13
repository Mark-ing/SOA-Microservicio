package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SOA.entidad.Solicitud_Cambio;
import com.SOA.repository.Solicitud_CambioRepository;

public class Solicitud_CambioService extends ICRUDImpl<Solicitud_Cambio, Integer>{

	@Autowired
	private Solicitud_CambioRepository repo;

	@Override
	public JpaRepository<Solicitud_Cambio, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}

