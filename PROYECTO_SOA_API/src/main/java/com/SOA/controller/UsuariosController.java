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

import com.SOA.entidad.Usuarios;
import com.SOA.servicesImpl.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService servicioUsuarios;
	
	@GetMapping("/listar")
	public List<Usuarios> listado() {
		return servicioUsuarios.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Usuarios consulta(@PathVariable("codigo") Integer cod) {
		return servicioUsuarios.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Usuarios area) {
		servicioUsuarios.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios area) {
		servicioUsuarios.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioUsuarios.eliminar(cod);
	}
}
