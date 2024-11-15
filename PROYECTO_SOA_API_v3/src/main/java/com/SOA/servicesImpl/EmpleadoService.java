package com.SOA.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Empleado;
import com.SOA.repository.EmpleadoRepository;

@Service
public class EmpleadoService extends ICRUDImpl<Empleado, Integer>{

	//inyeccion de dependencia
	@Autowired
	private EmpleadoRepository repo;

	@Override
	public JpaRepository<Empleado, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
	
}
