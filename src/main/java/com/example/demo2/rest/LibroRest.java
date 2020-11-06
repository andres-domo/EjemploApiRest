package com.example.demo2.rest;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dao.LibroRepositorio;
//import com.example.demo2.modelos.Autor;
import com.example.demo2.modelos.Libro;

@RestController
@RequestMapping("libros")
public class LibroRest {

	@Autowired
	private LibroRepositorio libroDao;
	
//métodos http; solicitud al servidor
	
	//método Post
	
	@PostMapping("/guardar")//http://localhost:8080/libros/guardar
	public void guardar(@RequestBody Libro libro){
		libroDao.save(libro);
	}
	
	  //método Get
	@GetMapping("/listar")//http://localhost:8080/libros/listar
	public List<Libro> listado(){
		
		return (List<Libro>) libroDao.findAll();
	}
	//método Get
	@RequestMapping("/listar/{id}")//http://localhost:8080/libros/listar/numero que quieras consultar.
	public Optional<Libro> listado_unitario(@PathVariable("id")int id){
		
		return libroDao.findById(id);
	}
	
	//método delete
	@DeleteMapping("/eliminar/{id}")//http://localhost:8080/libros/eliminar/numero que quieras eliminar.
	public void eliminar(@PathVariable("id") int id) {
		libroDao.deleteById(id);
	}
	
	//mëtodo Put
	@PutMapping("/actualizar")//http://localhost:8080/libros/actualizar
	public void actualizar(@RequestBody Libro libro) {
		libroDao.save(libro);
	}
	//MÉTODO get para consulta de @query del interface Dao. http://localhost:8080/libros/test1
	@GetMapping("/test1")
	public List<String> test1() {
		
	return libroDao.test1();
	}
	
	
}

