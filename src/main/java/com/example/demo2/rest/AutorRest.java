package com.example.demo2.rest;

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

import com.example.demo2.dao.AutorRepositorio;
import com.example.demo2.modelos.Autor;


@RestController
@RequestMapping("autor")
public class AutorRest {

	@Autowired
	private AutorRepositorio autorRepositorio;
	
	//métodos http; solicitud al servidor
	
		//método Post
		
		@PostMapping("/guardar")//http://localhost:8080/autor/guardar
		public void guardar(@RequestBody Autor autor){
			autorRepositorio.save(autor);
		}
		
		  //método Get
		@GetMapping("/listar")//http://localhost:8080/autor/listar
		public List<Autor> listado(){
			
			return (List<Autor>) autorRepositorio.findAll();
		}
		//método Get
		@RequestMapping("/listar/{id}")//http://localhost:8080/autor/listar/numero que quieras consultar.
		public Optional<Autor> listado_unitario(@PathVariable("id")int id){
			
			return autorRepositorio.findById(id);
		}
		
		//método delete
		@DeleteMapping("/eliminar/{id}")//http://localhost:8080/autor/eliminar/numero que quieras eliminar.
		public void eliminar(@PathVariable("id") int id) {
			autorRepositorio.deleteById(id);
		}
		
		//mëtodo Put
		@PutMapping("/actualizar")//http://localhost:8080/autor/actualizar
		public void actualizar(@RequestBody Autor autor) {
			autorRepositorio.save(autor);
		}
		
}
