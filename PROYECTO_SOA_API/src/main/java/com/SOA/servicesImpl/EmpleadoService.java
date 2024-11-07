package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Empleado;
import com.SOA.repository.EmpleadoRepository;

@Service
public class EmpleadoService extends ICRUDImpl<Empleado, Integer>{

	//inyeccion de dependencia
	@Autowired
	private EmpleadoRepository repo;
	
	
	
}
