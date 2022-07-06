package com.idat.Tarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Tarea.model.Estudiante;
import com.idat.Tarea.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository cliRep;
	
	@Override
	public void guardarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		cliRep.save(e);
	}

	@Override
	public void actualizarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		cliRep.saveAndFlush(e);
	}

	@Override
	public void eliminarEstudiante(Integer id) {
		// TODO Auto-generated method stub
		cliRep.deleteById(id);
	}

	@Override
	public List<Estudiante> listaEstudiantes() {
		// TODO Auto-generated method stub
		return cliRep.findAll();
	}

	@Override
	public Estudiante obtenerEstudianteId(Integer id) {
		// TODO Auto-generated method stub
		return cliRep.findById(id).orElse(null);
	}


}
