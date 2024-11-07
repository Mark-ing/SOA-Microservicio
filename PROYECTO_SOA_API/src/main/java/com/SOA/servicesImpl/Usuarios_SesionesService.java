package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Usuarios_Sesiones;
import com.SOA.repository.Usuarios_SesionesRepository;

@Service
public class Usuarios_SesionesService extends ICRUDImpl<Usuarios_Sesiones, Integer>{

	//inyeccion de dependencia
	@Autowired
	private Usuarios_SesionesRepository repo;
	

}
