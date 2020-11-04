package com.example.demo2.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro {

	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Título", nullable = false )
	private String titulo;
	
	
	@Column(name="Isbn")
	private int isbn;
	
	
	@OneToMany(mappedBy="libro")
	List<Autor>lista_autor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public List<Autor> getLista_autor() {
		return lista_autor;
	}
	public void setLista_autor(List<Autor> lista_autor) {
		this.lista_autor = lista_autor;
	}
	
	

	
	
	
}
