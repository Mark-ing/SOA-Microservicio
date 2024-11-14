package com.SOA.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SOA.entidad.Documento;
import com.SOA.repository.DocumentoRepository;

@Service
public class DocumentoService extends ICRUDImpl<Documento, Integer>{

	@Autowired
	private DocumentoRepository repo;

	@Override
	public JpaRepository<Documento, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}
	
}
