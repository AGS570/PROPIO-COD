package tests;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import negocio.FactoriaNegocio;
import negocio.pelicula.TPelicula;


// Realizar sobre un archivo JSON sin datos para que no influyan los resultados

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPeliculas {
	
	@Test
	public void test1_crear_pelicula1() {
		TPelicula pelicula = new TPelicula();

		pelicula.setId(-1);
		pelicula.setNombre("Pelicula Corrompida");
		pelicula.setDuracion(-1);
		pelicula.setClasificacion("error");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test2_crear_pelicula2() {
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[{\"duracion\":120,\"id\":1,\"clasificacion\":\"Intergalactico\",\"nombre\":\"Star Wars\"}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}

	@Test
	public void test3_crear_pelicula3() {
		TPelicula pelicula1 = new TPelicula();

		pelicula1.setId(1);
		pelicula1.setNombre("Star Wars");
		pelicula1.setDuracion(120);
		pelicula1.setClasificacion("Intergalactico");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula1);

		TPelicula pelicula2 = new TPelicula();

		pelicula2.setId(1);
		pelicula2.setNombre("Pelicula Duplicada");
		pelicula2.setDuracion(0);
		pelicula2.setClasificacion("Mal");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula2);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[{\"duracion\":120,\"id\":1,\"clasificacion\":\"Intergalactico\",\"nombre\":\"Star Wars\"}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}

	@Test
	public void test4_crear_pelicula4() {
		TPelicula pelicula1 = new TPelicula();

		pelicula1.setId(1);
		pelicula1.setNombre("Star Wars");
		pelicula1.setDuracion(120);
		pelicula1.setClasificacion("Intergalactico");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula1);

		TPelicula pelicula2 = new TPelicula();

		pelicula2.setId(2);
		pelicula2.setNombre("Gladiator");
		pelicula2.setDuracion(200);
		pelicula2.setClasificacion("Accion");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula2);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[{\"duracion\":120,\"id\":1,\"clasificacion\":\"Intergalactico\",\"nombre\":\"Star Wars\"},{\"duracion\":200,\"id\":2,\"clasificacion\":\"Accion\",\"nombre\":\"Gladiator\"}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test5_eliminar_pelicula() {
		TPelicula pelicula1 = new TPelicula();
		pelicula1.setId(1);
		pelicula1.setNombre("Star Wars");
		pelicula1.setDuracion(120);
		pelicula1.setClasificacion("Intergalactico");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula1);

		TPelicula pelicula2 = new TPelicula();
		pelicula2.setId(2);
		pelicula2.setNombre("Gladiator");
		pelicula2.setDuracion(200);
		pelicula2.setClasificacion("Accion");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula2);
		
		TPelicula pelicula3 = new TPelicula();
		pelicula3.setId(3);
		pelicula3.setNombre("Titanic");
		pelicula3.setDuracion(150);
		pelicula3.setClasificacion("Historia");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula3);
		
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(1);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(2);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(3);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test6_actualizar_pelicula1() {
		TPelicula pelicula1 = new TPelicula();

		pelicula1.setId(3);
		pelicula1.setNombre("Titanik");
		pelicula1.setDuracion(150);
		pelicula1.setClasificacion("Salvaje Oeste");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula1);

		TPelicula actualizacion = new TPelicula();

		actualizacion.setId(3);
		actualizacion.setNombre("Titanic");
		actualizacion.setClasificacion("Historia");

		FactoriaNegocio.getInstance().hacerSAPelicula().update(actualizacion);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[{\"duracion\":150,\"id\":3,\"clasificacion\":\"Historia\",\"nombre\":\"Titanic\"}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test7_actualizar_pelicula2() {
		TPelicula pelicula = new TPelicula();

		pelicula.setId(2);
		pelicula.setNombre("Gladiator");
		pelicula.setDuracion(200);
		pelicula.setClasificacion("Accion");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TPelicula actualizacion = new TPelicula();

		actualizacion.setId(99);
		actualizacion.setNombre("No Existo");
		actualizacion.setDuracion(0);
		actualizacion.setClasificacion("Mal");

		FactoriaNegocio.getInstance().hacerSAPelicula().update(actualizacion);

		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("peliculas");

		String correcto = "[{\"duracion\":200,\"id\":2,\"clasificacion\":\"Accion\",\"nombre\":\"Gladiator\"}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	
	// Se ejecuta despues de cada test, limpia lo que ha hecho
	@After
	public void limpiar(){
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(1);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(2);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(3);
	}
}