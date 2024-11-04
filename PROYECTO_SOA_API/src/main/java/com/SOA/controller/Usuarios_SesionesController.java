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

import com.SOA.entidad.Usuarios_Sesiones;
import com.SOA.services.Usuarios_SesionesService;

@RestController
@RequestMapping("/usuarios_sesiones")
public class Usuarios_SesionesController {

	@Autowired
	private Usuarios_SesionesService servicioUsuarios_Sesiones;
	
	@GetMapping("/listar")
	public List<Usuarios_Sesiones> listado() {
		return servicioUsuarios_Sesiones.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Usuarios_Sesiones consulta(@PathVariable("codigo") Integer cod) {
		return servicioUsuarios_Sesiones.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Usuarios_Sesiones area) {
		servicioUsuarios_Sesiones.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios_Sesiones area) {
		servicioUsuarios_Sesiones.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioUsuarios_Sesiones.eliminar(cod);
	}
}
