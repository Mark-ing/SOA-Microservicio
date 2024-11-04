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

import com.SOA.entidad.Rol_Usuarios;
import com.SOA.services.Rol_UsuariosService;

@RestController
@RequestMapping("/rol_usuarios")
public class Rol_UsuariosController {

	@Autowired
	private Rol_UsuariosService servicioRol_Usuarios;
	
	@GetMapping("/listar")
	public List<Rol_Usuarios> listado() {
		return servicioRol_Usuarios.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Rol_Usuarios consulta(@PathVariable("codigo") Integer cod) {
		return servicioRol_Usuarios.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Rol_Usuarios area) {
		servicioRol_Usuarios.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Rol_Usuarios area) {
		servicioRol_Usuarios.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioRol_Usuarios.eliminar(cod);
	}
}
