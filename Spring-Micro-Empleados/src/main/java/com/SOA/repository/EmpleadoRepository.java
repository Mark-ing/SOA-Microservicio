package com.SOA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SOA.entidad.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
