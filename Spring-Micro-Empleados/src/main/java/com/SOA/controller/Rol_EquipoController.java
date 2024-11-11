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

import com.SOA.dto.Rol_EquipoDTO;
import com.SOA.entidad.Rol_Equipo;
import com.SOA.servicesImpl.Rol_EquipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rol_equipo")
public class Rol_EquipoController {

	@Autowired
	private Rol_EquipoService servicioRol_Equipo;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<Rol_EquipoDTO> listado() throws Exception{
		List<Rol_EquipoDTO> lista=servicioRol_Equipo.listar().stream().map(p->
			mapper.map(p, Rol_EquipoDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Rol_EquipoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Rol_Equipo bean=servicioRol_Equipo.buscar(cod);
		return mapper.map(bean, Rol_EquipoDTO.class);
	}
	
	@PostMapping("/registrar")
	public Rol_EquipoDTO registrar(@Valid @RequestBody Rol_EquipoDTO roleq) throws Exception{
		Rol_Equipo bean=null;
		bean=mapper.map(roleq, Rol_Equipo.class);
		bean=servicioRol_Equipo.registrar(bean);
		return mapper.map(bean, Rol_EquipoDTO.class);
	}
	
	@PutMapping("/actualizar")
	public Rol_EquipoDTO actualizar(@Valid @RequestBody Rol_EquipoDTO roleq) throws Exception{
		Rol_Equipo bean=null;
		bean=mapper.map(roleq, Rol_Equipo.class);
		bean=servicioRol_Equipo.actualizar(bean);
		return mapper.map(bean, Rol_EquipoDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioRol_Equipo.eliminar(cod);
	}
}
