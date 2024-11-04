package com.SOA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.entidad.Empleado;
import com.SOA.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicioEmpleado;
	
	@GetMapping("/listar")
	public List<Empleado> listado() {
		return servicioEmpleado.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Empleado consulta(@PathVariable("codigo") Integer cod) {
		return servicioEmpleado.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Empleado area) {
		servicioEmpleado.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Empleado area) {
		servicioEmpleado.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioEmpleado.eliminar(cod);
	}
}
