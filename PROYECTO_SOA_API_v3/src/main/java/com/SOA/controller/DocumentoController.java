package com.SOA.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.dto.DocumentoDTO;
import com.SOA.entidad.Documento;
import com.SOA.servicesImpl.DocumentoService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService servicioDocumento;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/listar")
	public List<DocumentoDTO> listado() throws Exception {
	    List<DocumentoDTO> lista = servicioDocumento.listar().stream().map(p ->
	        mapper.map(p, DocumentoDTO.class)).collect(Collectors.toList());
	    return lista;
	}

	@GetMapping("/consultarPorId/{codigo}")
	public DocumentoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception {
	    Documento bean = servicioDocumento.buscar(cod);
	    if (bean == null)
	        throw new ModeloNotFoundException("Codigo no existe");
	    else
	        return mapper.map(bean, DocumentoDTO.class);
	}

	@PostMapping("/registrar")
	public DocumentoDTO registrar(@Valid @RequestBody DocumentoDTO documento) throws Exception {
	    Documento bean = null;
	    bean = mapper.map(documento, Documento.class);
	    bean = servicioDocumento.registrar(bean);
	    return mapper.map(bean, DocumentoDTO.class);
	}

	@PutMapping("/actualizar")
	public DocumentoDTO actualizar(@Valid @RequestBody DocumentoDTO documento) throws Exception {
	    Documento bean = null;
	    bean = mapper.map(documento, Documento.class);
	    bean = servicioDocumento.actualizar(bean);
	    return mapper.map(bean, DocumentoDTO.class);
	}

	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception {
	    servicioDocumento.eliminar(cod);
	}

}
