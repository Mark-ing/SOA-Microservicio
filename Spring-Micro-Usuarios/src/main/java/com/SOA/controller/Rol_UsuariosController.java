package com.SOA.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.dto.Rol_UsuariosDTO;
import com.SOA.entidad.Rol_Usuarios;
import com.SOA.servicesImpl.Rol_UsuariosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rol_usuarios")
public class Rol_UsuariosController {

	@Autowired
	private Rol_UsuariosService servicioRol_Usuarios;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<Rol_UsuariosDTO> listado() throws Exception{
		List<Rol_UsuariosDTO> lista=servicioRol_Usuarios.listar().stream().map(p->
			mapper.map(p, Rol_UsuariosDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Rol_UsuariosDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Rol_Usuarios bean=servicioRol_Usuarios.buscar(cod);
		return mapper.map(bean, Rol_UsuariosDTO.class);
	}
	
	@PostMapping("/registrar")
	public Rol_UsuariosDTO registrar(@Valid @RequestBody Rol_UsuariosDTO rolus) throws Exception{
		Rol_Usuarios bean=null;
		bean=mapper.map(rolus, Rol_Usuarios.class);
		bean=servicioRol_Usuarios.registrar(bean);
		return mapper.map(bean, Rol_UsuariosDTO.class);
	}
	
	@PutMapping("/actualizar")
	public Rol_UsuariosDTO actualizar(@Valid @RequestBody Rol_UsuariosDTO rolus) throws Exception{
		Rol_Usuarios bean=null;
		bean=mapper.map(rolus, Rol_Usuarios.class);
		bean=servicioRol_Usuarios.actualizar(bean);
		return mapper.map(bean, Rol_UsuariosDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioRol_Usuarios.eliminar(cod);
	}
}
