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

import com.SOA.dto.Usuarios_SesionesDTO;
import com.SOA.entidad.Usuarios_Sesiones;
import com.SOA.servicesImpl.Usuarios_SesionesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios_sesiones")
public class Usuarios_SesionesController {

	@Autowired
	private Usuarios_SesionesService servicioUsuarios_Sesiones;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<Usuarios_SesionesDTO> listado() throws Exception{
		List<Usuarios_SesionesDTO> lista=servicioUsuarios_Sesiones.listar().stream().map(p->
			mapper.map(p, Usuarios_SesionesDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Usuarios_SesionesDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Usuarios_Sesiones bean=servicioUsuarios_Sesiones.buscar(cod);
		return mapper.map(bean, Usuarios_SesionesDTO.class);
	}
	
	@PostMapping("/registrar")
	public Usuarios_SesionesDTO registrar(@Valid @RequestBody Usuarios_SesionesDTO usse) throws Exception{
		Usuarios_Sesiones bean=null;
		bean=mapper.map(usse, Usuarios_Sesiones.class);
		bean=servicioUsuarios_Sesiones.registrar(bean);
		return mapper.map(bean, Usuarios_SesionesDTO.class);
	}
	
	@PutMapping("/actualizar")
	public Usuarios_SesionesDTO actualizar(@Valid @RequestBody Usuarios_SesionesDTO usse) throws Exception{
		Usuarios_Sesiones bean=null;
		bean=mapper.map(usse, Usuarios_Sesiones.class);
		bean=servicioUsuarios_Sesiones.actualizar(bean);
		return mapper.map(bean, Usuarios_SesionesDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioUsuarios_Sesiones.eliminar(cod);
	}
}
