package com.example.demo2.modelos;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
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

	//@OneToMany(mappedBy = "libro")
	//private List<Autor> lista_autor;

	public Libro(int id, String titulo, int isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		
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

	/*public List<Autor> getLista_autor() {
		return lista_autor;
	}

	public void setLista_autor(List<Autor> lista_autor) {
		this.lista_autor = lista_autor;
	}*/

}
