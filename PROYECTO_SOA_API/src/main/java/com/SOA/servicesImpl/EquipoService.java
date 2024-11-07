package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Equipo;
import com.SOA.repository.EquipoRepository;

@Service
public class EquipoService extends ICRUDImpl<Equipo, Integer>{
	
	//inyeccion de dependencia
	@Autowired
	private EquipoRepository repo;
	
	
}
