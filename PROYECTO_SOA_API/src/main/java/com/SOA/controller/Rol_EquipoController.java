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

import com.SOA.entidad.Rol_Equipo;
import com.SOA.servicesImpl.Rol_EquipoService;

@RestController
@RequestMapping("/rol_equipo")
public class Rol_EquipoController {

	@Autowired
	private Rol_EquipoService servicioRol_Equipo;
	
	@GetMapping("/listar")
	public List<Rol_Equipo> listado() {
		return servicioRol_Equipo.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Rol_Equipo consulta(@PathVariable("codigo") Integer cod) {
		return servicioRol_Equipo.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Rol_Equipo area) {
		servicioRol_Equipo.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Rol_Equipo area) {
		servicioRol_Equipo.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioRol_Equipo.eliminar(cod);
	}
}
