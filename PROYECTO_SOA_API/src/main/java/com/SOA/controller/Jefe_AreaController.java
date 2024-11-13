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

import com.SOA.dto.Jefe_AreaDTO;
import com.SOA.entidad.Jefe_Area;
import com.SOA.servicesImpl.Jefe_AreaService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jefe_area")
public class Jefe_AreaController {

	@Autowired
	private Jefe_AreaService servicioJefe_Area;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<Jefe_AreaDTO> listado() throws Exception {
	    List<Jefe_AreaDTO> lista = servicioJefe_Area.listar().stream().map(p ->
	        mapper.map(p, Jefe_AreaDTO.class)).collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public Jefe_AreaDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Jefe_Area bean = servicioJefe_Area.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, Jefe_AreaDTO.class);
	}

	@PostMapping("/registrar")
	public Jefe_AreaDTO registrar(@Valid @RequestBody Jefe_AreaDTO jefe_area) throws Exception {
	    Jefe_Area bean = null;
	    bean = mapper.map(jefe_area, Jefe_Area.class);
	    bean = servicioJefe_Area.registrar(bean);
	    return mapper.map(bean, Jefe_AreaDTO.class);
	}

	@PutMapping("/actualizar")
	public Jefe_AreaDTO actualizar(@Valid @RequestBody Jefe_AreaDTO jefe_area) throws Exception {
	    Jefe_Area bean = null;
	    bean = mapper.map(jefe_area, Jefe_Area.class);
	    bean = servicioJefe_Area.actualizar(bean);
	    return mapper.map(bean, Jefe_AreaDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioJefe_Area.eliminar(cod);
	}

}
