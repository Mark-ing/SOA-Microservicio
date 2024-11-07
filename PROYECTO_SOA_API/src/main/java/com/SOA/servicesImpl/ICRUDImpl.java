package com.SOA.servicesImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SOA.services.ICRUD;

public abstract class ICRUDImpl<T,ID> implements ICRUD<T, ID>{

	public abstract JpaRepository<T, ID> getJpaRepository();
	
	@Override
	public T registrar(T bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T actualizar(T bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(ID cod) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T buscar(ID cod) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
