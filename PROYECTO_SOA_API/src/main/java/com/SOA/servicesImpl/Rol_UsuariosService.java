package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Rol_Usuarios;
import com.SOA.repository.Rol_UsuariosRepository;

@Service
public class Rol_UsuariosService extends ICRUDImpl<Rol_Usuarios, Integer>{

	//inyeccion de dependencia
	@Autowired
	private Rol_UsuariosRepository repo;
	
	
}
