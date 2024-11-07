package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Rol_Equipo;
import com.SOA.repository.Rol_EquipoRepository;

@Service
public class Rol_EquipoService extends ICRUDImpl<Rol_Equipo, Integer>{

	//inyeccion de dependencia
	@Autowired
	private Rol_EquipoRepository repo;
	
	
}
