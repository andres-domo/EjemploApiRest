package com.example.demo2.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Autores")
public class Autor {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "Apellidos")
	private String apellidos;

	@ManyToOne
	@JoinColumn(name = "libro_Id")
	@JsonIgnore
	private Libro libro;
	
	public Autor(int id, String nombre, String apellidos, Libro libro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.libro = libro;
	}

	public Autor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Libro getIdLibro() {
		return libro;
	}
	@JsonIgnore
	public void setIdLibro(Libro libro) {
		this.libro = libro;
	}

}
