package com.SOA.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.dto.ProyectoDTO;
import com.SOA.entidad.Proyecto;
import com.SOA.servicesImpl.ProyectoService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoService servicioProyecto;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<ProyectoDTO> listado() throws Exception {
	    List<ProyectoDTO> lista = servicioProyecto.listar().stream().map(p ->
	        mapper.map(p, ProyectoDTO.class)).collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public ProyectoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Proyecto bean = servicioProyecto.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, ProyectoDTO.class);
	}

	@PostMapping("/registrar")
	public ProyectoDTO registrar(@Valid @RequestBody ProyectoDTO proyecto) throws Exception {
	    Proyecto bean = null;
	    bean = mapper.map(proyecto, Proyecto.class);
	    bean = servicioProyecto.registrar(bean);
	    return mapper.map(bean, ProyectoDTO.class);
	}

	@PutMapping("/actualizar")
	public ProyectoDTO actualizar(@Valid @RequestBody ProyectoDTO proyecto) throws Exception {
	    Proyecto bean = null;
	    bean = mapper.map(proyecto, Proyecto.class);
	    bean = servicioProyecto.actualizar(bean);
	    return mapper.map(bean, ProyectoDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioProyecto.eliminar(cod);
	}

}
