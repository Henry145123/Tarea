package com.idat.Tarea.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Tarea.model.Estudiante;
import com.idat.Tarea.service.EstudianteService;



@RestController
@RequestMapping("/estudiante/v1")
public class EstudianteRestController {
	@Autowired
	private EstudianteService estuServ;
	
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<Collection<Estudiante>>  listar(){
		
		 return new ResponseEntity<Collection<Estudiante>>( estuServ.listaEstudiantes(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Estudiante estudiante) {
		estuServ.guardarEstudiante(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="/borrar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Estudiante c = estuServ.obtenerEstudianteId(id);
		if(c!=null) {
			estuServ.eliminarEstudiante(id);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/buscar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id){
		Estudiante e =estuServ.obtenerEstudianteId(id);
		if(e!=null) {
			return new ResponseEntity<Estudiante>(e,HttpStatus.OK);
		}
		return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar",method=RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Estudiante e){
		
		Estudiante est=estuServ.obtenerEstudianteId(e.getIdEstudiante());		
		if(est!=null) {
			estuServ.actualizarEstudiante(e);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}