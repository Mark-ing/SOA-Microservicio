package com.SOA.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Rol_Usuarios;
import com.SOA.repository.Rol_UsuariosRepository;

@Service
public class Rol_UsuariosService extends ICRUDImpl<Rol_Usuarios, Integer>{

	//inyeccion de dependencia
	@Autowired
	private Rol_UsuariosRepository repo;

	@Override
	public JpaRepository<Rol_Usuarios, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
