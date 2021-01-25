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

import com.example.demo2.dao.AutorRepositorio;
import com.example.demo2.modelos.Autor;

import com.example.demo2.rest.AutorRest;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AutorRestTest {

	@InjectMocks
	AutorRest autorest;

	@Mock
	private AutorRepositorio Mockautorrep;

	@Autowired
	Autor autor1;

	private static int id = 1;

	private static String nombre = "J.K.Rowling";

	private static final String apellidos = "Martinez Sousa";

	private Autor autordto;

	@Before//antes de los test
	public void prepare() throws ServiceException, ValidationException {

		autordto = new Autor();
		autordto.setId(id);
		autordto.setNombre(nombre);
		autordto.setApellidos(apellidos);

		List<Autor> todosLosAutores = new ArrayList<Autor>();
		todosLosAutores.add(autordto);

		// getTodosLosautores
		when(Mockautorrep.findAll()).thenReturn(todosLosAutores);

	}

	@Test
	public void TestListarAutores() throws ServiceException {

		List<Autor> todosLosAutores = (List<Autor>) autorest.listado();

		Assert.assertNotNull(todosLosAutores);
		Assert.assertEquals(todosLosAutores.get(0).getId(), id);

	}

	@Test
	public void testListado_Unitario_autor() throws ServiceException, ValidationException {
		Optional<Autor> autor = autorest.listado_unitario(id);

		Assert.assertNotNull(autor);
		Assert.assertEquals(autor, Mockautorrep.findById(id));
	}

	@Test
	public void TestEliminarAutor() {

		autor1 = new Autor(2, "javier", "fernandez", null);
		autorest.eliminar(2);

		verify(Mockautorrep).deleteById(2);

	}
	
	@Test
	public void TestguardarAutor(){
		
		Autor autor2 = new Autor (3,"Roberto","Fresnedoso Gil",null);
		autorest.guardar(autor2);
		
		verify(Mockautorrep).save(autor2);
	}
	
	@Test
	public void TestactualizarAutor()throws ServiceException, ValidationException {

		Autor autor33 = new Autor(33,"Jose","Dominguez",null);
		autor33.setId(5);
		autorest.actualizar(autor33);

		verify(Mockautorrep).save(autor33);

		// Assert.assertEquals( libro3, Mocklibrorep.save(libro3));
	}
	
	
	@Test
	public void Testtest2() {
		
		Autor autor14 = new Autor();
		autor14.setId(25);
		autor14.setNombre("Roberto");
		autor14.setApellidos("Gil Morente");
		autor14.setIdLibro(null);
		
		List<String>tnombreAutoresList=autorest.test2();
		
		Assert.assertNotNull(tnombreAutoresList);
		Assert.assertEquals(tnombreAutoresList, Mockautorrep.test2());

		
		}

}
