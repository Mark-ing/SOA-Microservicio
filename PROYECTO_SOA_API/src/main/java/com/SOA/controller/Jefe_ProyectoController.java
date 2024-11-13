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

import com.SOA.dto.Jefe_ProyectoDTO;
import com.SOA.entidad.Jefe_Proyecto;
import com.SOA.servicesImpl.Jefe_ProyectoService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jefe_proyecto")
public class Jefe_ProyectoController {

	@Autowired
	private Jefe_ProyectoService servicioJefe_Proyecto;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<Jefe_ProyectoDTO> listado() throws Exception {
	    List<Jefe_ProyectoDTO> lista = servicioJefe_Proyecto.listar().stream().map(p ->
	        mapper.map(p, Jefe_ProyectoDTO.class)).collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public Jefe_ProyectoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Jefe_Proyecto bean = servicioJefe_Proyecto.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, Jefe_ProyectoDTO.class);
	}

	@PostMapping("/registrar")
	public Jefe_ProyectoDTO registrar(@Valid @RequestBody Jefe_ProyectoDTO jefe_proyecto) throws Exception {
	    Jefe_Proyecto bean = null;
	    bean = mapper.map(jefe_proyecto, Jefe_Proyecto.class);
	    bean = servicioJefe_Proyecto.registrar(bean);
	    return mapper.map(bean, Jefe_ProyectoDTO.class);
	}

	@PutMapping("/actualizar")
	public Jefe_ProyectoDTO actualizar(@Valid @RequestBody Jefe_ProyectoDTO jefe_proyecto) throws Exception {
	    Jefe_Proyecto bean = null;
	    bean = mapper.map(jefe_proyecto, Jefe_Proyecto.class);
	    bean = servicioJefe_Proyecto.actualizar(bean);
	    return mapper.map(bean, Jefe_ProyectoDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioJefe_Proyecto.eliminar(cod);
	}

}
