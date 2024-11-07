package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Usuarios;
import com.SOA.repository.UsuariosRepository;

@Service
public class UsuariosService extends ICRUDImpl<Usuarios, Integer>{

	//inyeccion de dependencia
	@Autowired
	private UsuariosRepository repo;
	
	
}