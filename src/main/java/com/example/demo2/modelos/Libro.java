package com.example.demo2.modelos;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Titulo", nullable = false, unique = true)
	private String titulo;

	@Column(name = "Isbn", unique = true)
	private int isbn;

	@OneToMany(mappedBy = "libro",cascade = CascadeType.ALL)
	private List<Autor> autores;

	
		
	public Libro(int id, String titulo, int isbn, List<Autor> autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.autores = autores;
	}


	public Libro() {
		super();
	}



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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	

	//metodo para la relacion
	
		public void agregarAutor(Autor coautor){
		if (autores==null) autores=new ArrayList<>();
		autores.add(coautor);
		coautor.setIdLibro(this);
		}


	
	
}
