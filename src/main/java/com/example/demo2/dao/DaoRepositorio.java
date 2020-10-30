package com.example.demo2.dao;


import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo2.modelos.Libro;

public interface DaoRepositorio extends CrudRepository<Libro, Integer>{

	//@Query(value = "SELECT u FROM Libros U")
	//List<Libro> findAllLibro(Sort sort);
	
	@Query (value= "SELECT Autor FROM Libros", nativeQuery = true)
	List<String> test1();
}
