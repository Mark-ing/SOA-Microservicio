package com.SOA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SOA.entidad.Area;
import com.SOA.services.AreaService;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService servicioArea;
	
	@GetMapping("/listar")
	public List<Area> listado() {
		return servicioArea.listar();
	}
	
	@GetMapping("/consultarPorId/{codigo}")
	public Area consulta(@PathVariable("codigo") Integer cod) {
		return servicioArea.buscar(cod);
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Area area) {
		servicioArea.registrar(area);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Area area) {
		servicioArea.actualizar(area);
	}
	
	@DeleteMapping("/eliminarPorId/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) {
		servicioArea.eliminar(cod);
	}
}
