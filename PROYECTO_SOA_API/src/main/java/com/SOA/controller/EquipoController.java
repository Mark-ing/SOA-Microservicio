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

import com.SOA.dto.EquipoDTO;
import com.SOA.entidad.Equipo;
import com.SOA.servicesImpl.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

	@Autowired
	private EquipoService servicioEquipo;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<EquipoDTO> listado() throws Exception{
		List<EquipoDTO> lista=servicioEquipo.listar().stream().map(p->
			mapper.map(p, EquipoDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public EquipoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Equipo bean=servicioEquipo.buscar(cod);
		return mapper.map(bean, EquipoDTO.class);
	}
	
	@PostMapping("/registrar")
	public EquipoDTO registrar(@RequestBody EquipoDTO equipo) throws Exception{
		Equipo bean=null;
		bean=mapper.map(equipo, Equipo.class);
		bean=servicioEquipo.registrar(bean);
		return mapper.map(bean, EquipoDTO.class);
	}
	
	@PutMapping("/actualizar")
	public EquipoDTO actualizar(@RequestBody EquipoDTO equipo) throws Exception{
		Equipo bean=null;
		bean=mapper.map(equipo, Equipo.class);
		bean=servicioEquipo.actualizar(bean);
		return mapper.map(bean, EquipoDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioEquipo.eliminar(cod);
	}
}
