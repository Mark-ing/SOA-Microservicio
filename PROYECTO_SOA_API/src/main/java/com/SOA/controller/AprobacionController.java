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

import com.SOA.dto.AprobacionDTO;
import com.SOA.entidad.Aprobacion;
import com.SOA.servicesImpl.AprobacionService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aprobacion")
public class AprobacionController {

	@Autowired
	private AprobacionService servicioAprobacion;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<AprobacionDTO> listado() throws Exception {
	    List<AprobacionDTO> lista = servicioAprobacion.listar().stream()
	        .map(p -> mapper.map(p, AprobacionDTO.class))
	        .collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public AprobacionDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Aprobacion bean = servicioAprobacion.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, AprobacionDTO.class);
	}

	@PostMapping("/registrar")
	public AprobacionDTO registrar(@Valid @RequestBody AprobacionDTO aprobacion) throws Exception {
	    Aprobacion bean = null;
	    bean = mapper.map(aprobacion, Aprobacion.class);
	    bean = servicioAprobacion.registrar(bean);
	    return mapper.map(bean, AprobacionDTO.class);
	}

	@PutMapping("/actualizar")
	public AprobacionDTO actualizar(@Valid @RequestBody AprobacionDTO aprobacion) throws Exception {
	    Aprobacion bean = null;
	    bean = mapper.map(aprobacion, Aprobacion.class);
	    bean = servicioAprobacion.actualizar(bean);
	    return mapper.map(bean, AprobacionDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioAprobacion.eliminar(cod);
	}


}