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

import com.SOA.dto.EmpleadoDTO;
import com.SOA.entidad.Empleado;
import com.SOA.servicesImpl.EmpleadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicioEmpleado;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<EmpleadoDTO> listado() throws Exception{
		List<EmpleadoDTO> lista=servicioEmpleado.listar().stream().map(p->
			mapper.map(p, EmpleadoDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public EmpleadoDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Empleado bean=servicioEmpleado.buscar(cod);
		return mapper.map(bean, EmpleadoDTO.class);
	}
	
	@PostMapping("/registrar")
	public EmpleadoDTO registrar(@Valid @RequestBody EmpleadoDTO emp) throws Exception{
		Empleado bean=null;
		bean=mapper.map(emp, Empleado.class);
		bean=servicioEmpleado.registrar(bean);
		return mapper.map(bean, EmpleadoDTO.class);
	}
	
	@PutMapping("/actualizar")
	public EmpleadoDTO actualizar(@Valid @RequestBody EmpleadoDTO emp) throws Exception{
		Empleado bean=null;
		bean=mapper.map(emp, Empleado.class);
		bean=servicioEmpleado.actualizar(bean);
		return mapper.map(bean, EmpleadoDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioEmpleado.eliminar(cod);
	}
}
