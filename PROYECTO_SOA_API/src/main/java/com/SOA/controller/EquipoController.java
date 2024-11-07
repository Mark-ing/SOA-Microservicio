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

import com.SOA.entidad.Equipo;
import com.SOA.servicesImpl.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

	@Autowired
	private EquipoService servicioEquipo;
	
	@GetMapping("/listar")
	public List<Equipo> listado() {
		return servicioEquipo.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Equipo consulta(@PathVariable("codigo") Integer cod) {
		return servicioEquipo.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Equipo area) {
		servicioEquipo.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Equipo area) {
		servicioEquipo.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioEquipo.eliminar(cod);
	}
}
