package com.example.demo2;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.hibernate.service.spi.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo2.dao.LibroRepositorio;
import com.example.demo2.modelos.Libro;
import com.example.demo2.rest.LibroRest;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LibroRestTest {

	@InjectMocks
	LibroRest librorest;

	@Mock
	private LibroRepositorio Mocklibrorep;

	// @Mock
	// private AutorRepositorio autorrepositorio;

	@Autowired
	Libro libro, libro1;

	private static int id = 1;

	private static String titulo = "El toquede queda";

	private static  int isbn = 76537643;

	private Libro librodto;

	@Before
	public void prepare() throws ServiceException, ValidationException {

		librodto = new Libro();
		librodto.setId(id);
		librodto.setTitulo(titulo);
		librodto.setIsbn(isbn);

		List<Libro> todosLoslibros = new ArrayList<Libro>();
		todosLoslibros.add(librodto);

		// getTodosLoslibros
		when(Mocklibrorep.findAll()).thenReturn(todosLoslibros);

	}

	@Test
	public void TestListarLibros() throws ServiceException {

		List<Libro> todosLoslibros = (List<Libro>) librorest.listado();

		Assert.assertNotNull(todosLoslibros);

		Assert.assertEquals(todosLoslibros.get(0).getIsbn(), isbn);

	}

	@Test
	public void testListado_Unitario() throws ServiceException, ValidationException {
		Optional<Libro> libro = librorest.listado_unitario(id);

		Assert.assertNotNull(libro);
		Assert.assertEquals(libro, Mocklibrorep.findById(id));

	}

	@Test
	public void TestEliminarLibro() {

		libro1 = new Libro(2, "el pastor de belen", 45436436, null);
		List<Libro> todosLoslibros = new ArrayList<Libro>();
		todosLoslibros.add(libro1);
		librorest.eliminar(2);
	
		verify(Mocklibrorep).deleteById(2);
		Assert.assertNotNull(todosLoslibros);
	}

	@Test
	public void TestguardarLibro() {

		Libro libro2 = new Libro(3, "las obejas negras se vuelven cabras locas", 234352, null);
		
		List<Libro> todosLoslibros = new ArrayList<Libro>();
		todosLoslibros.add(libro2);
		librorest.guardar(libro2);

		verify(Mocklibrorep).save(libro2);
	}

	@Test
	public void TestactualizarLibro()throws ServiceException, ValidationException {

		Libro libro3 = new Libro(4, "las lagartijas de Guantanamo", 234552, null);
		libro3.setId(5);
		librorest.actualizar(libro3);

		verify(Mocklibrorep).save(libro3);

		// Assert.assertEquals( libro3, Mocklibrorep.save(libro3));
	}
	
	
	@Test
	public void Testtest1() {
		
		Libro libro4 = new Libro();
		libro4.setId(22);
		libro4.setIsbn(454223);
		libro4.setTitulo("los duendes de arriba");
		libro4.setAutores(null);
		
		List<String>titulolibrosList=librorest.test1();
		
		Assert.assertNotNull(titulolibrosList);
		Assert.assertEquals(titulolibrosList, Mocklibrorep.test1());

		
		}
	
	

	// @Test(expected = ValidationException.class)
	// public void testBorrorUsuario() throws ServiceException,
	// ValidationException {

	// librorest.eliminar(0);
	// }

}


