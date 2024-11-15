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

import com.SOA.dto.AreaDTO;
import com.SOA.entidad.Area;
import com.SOA.servicesImpl.AreaService;
import com.SOA.utils.ModeloNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService servicioArea;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<AreaDTO> listado() throws Exception{
		List<AreaDTO> lista=servicioArea.listar().stream().map(p->
			mapper.map(p, AreaDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public AreaDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Area bean=servicioArea.buscar(cod);
		if (bean==null)
			throw new ModeloNotFoundException("Codigo no existe");
		else
			return mapper.map(bean, AreaDTO.class);
	}
	
	@PostMapping("/registrar")
	public AreaDTO registrar(@Valid @RequestBody AreaDTO area) throws Exception{
		Area bean=null;
		bean=mapper.map(area, Area.class);
		bean=servicioArea.registrar(bean);
		return mapper.map(bean, AreaDTO.class);
	}
	
	@PutMapping("/actualizar")
	public AreaDTO actualizar(@Valid @RequestBody AreaDTO area) throws Exception{
		Area bean=null;
		bean=mapper.map(area, Area.class);
		bean=servicioArea.actualizar(bean);
		return mapper.map(bean, AreaDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioArea.eliminar(cod);
	}
}
