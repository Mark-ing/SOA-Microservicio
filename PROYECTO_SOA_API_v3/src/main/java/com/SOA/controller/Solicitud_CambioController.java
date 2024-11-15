package com.SOA.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.dto.Solicitud_CambioDTO;
import com.SOA.entidad.Solicitud_Cambio;
import com.SOA.servicesImpl.Solicitud_CambioService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/solicitud_cambio")
public class Solicitud_CambioController {

	@Autowired
	private Solicitud_CambioService servicioSolicitud_Cambio;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<Solicitud_CambioDTO> listado() throws Exception {
	    List<Solicitud_CambioDTO> lista = servicioSolicitud_Cambio.listar().stream().map(p ->
	        mapper.map(p, Solicitud_CambioDTO.class)).collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public Solicitud_CambioDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Solicitud_Cambio bean = servicioSolicitud_Cambio.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, Solicitud_CambioDTO.class);
	}

	@PostMapping("/registrar")
	public Solicitud_CambioDTO registrar(@Valid @RequestBody Solicitud_CambioDTO solicitud_Cambio) throws Exception {
	    Solicitud_Cambio bean = null;
	    bean = mapper.map(solicitud_Cambio, Solicitud_Cambio.class);
	    bean = servicioSolicitud_Cambio.registrar(bean);
	    return mapper.map(bean, Solicitud_CambioDTO.class);
	}

	@PutMapping("/actualizar")
	public Solicitud_CambioDTO actualizar(@Valid @RequestBody Solicitud_CambioDTO solicitud_Cambio) throws Exception {
	    Solicitud_Cambio bean = null;
	    bean = mapper.map(solicitud_Cambio, Solicitud_Cambio.class);
	    bean = servicioSolicitud_Cambio.actualizar(bean);
	    return mapper.map(bean, Solicitud_CambioDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioSolicitud_Cambio.eliminar(cod);
	}

}
