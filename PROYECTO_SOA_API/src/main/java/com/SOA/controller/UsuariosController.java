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

import com.SOA.dto.UsuariosDTO;
import com.SOA.entidad.Usuarios;
import com.SOA.servicesImpl.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService servicioUsuarios;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public List<UsuariosDTO> listado() throws Exception{
		List<UsuariosDTO> lista=servicioUsuarios.listar().stream().map(p->
			mapper.map(p, UsuariosDTO.class)).collect(Collectors.toList());
		return lista;
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public UsuariosDTO consulta(@PathVariable("codigo") Integer cod) throws Exception{
		Usuarios bean=servicioUsuarios.buscar(cod);
		return mapper.map(bean, UsuariosDTO.class);
	}
	
	@PostMapping("/registrar")
	public UsuariosDTO registrar(@RequestBody UsuariosDTO us) throws Exception{
		Usuarios bean=null;
		bean=mapper.map(us, Usuarios.class);
		bean=servicioUsuarios.registrar(bean);
		return mapper.map(bean, UsuariosDTO.class);
	}
	
	@PutMapping("/actualizar")
	public UsuariosDTO actualizar(@RequestBody UsuariosDTO us) throws Exception{
		Usuarios bean=null;
		bean=mapper.map(us, Usuarios.class);
		bean=servicioUsuarios.actualizar(bean);
		return mapper.map(bean, UsuariosDTO.class);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		servicioUsuarios.eliminar(cod);
	}
}
