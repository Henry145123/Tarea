package com.idat.Tarea.service;

import java.util.List;

import com.idat.Tarea.model.Estudiante;



public interface EstudianteService {
	
	void guardarEstudiante(Estudiante e);
	void actualizarEstudiante(Estudiante e);
	void eliminarEstudiante(Integer id);
	List<Estudiante> listaEstudiantes();
	Estudiante obtenerEstudianteId(Integer id);

}
