package com.idat.Tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Tarea.model.Estudiante;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>  {

}
