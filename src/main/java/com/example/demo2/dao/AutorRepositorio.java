package com.example.demo2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo2.modelos.Autor;

public interface AutorRepositorio extends CrudRepository <Autor, Integer> {

	@Query (value= "SELECT nombre FROM Autores", nativeQuery = true)
	List<String> test2();
	
}
