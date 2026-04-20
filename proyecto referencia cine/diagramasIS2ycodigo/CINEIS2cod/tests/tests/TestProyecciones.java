package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import negocio.FactoriaNegocio;
import negocio.pelicula.TPelicula;
import negocio.proyeccion.TProyeccion;
import negocio.sala.TSalaNormal;
import negocio.sala.TSalaVip;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProyecciones {

	@Test
	public void test1_crear_proyeccion1(){//proy invalida, no se guarda en bd
		TProyeccion proy = new TProyeccion();
		proy.setID(-1);
		proy.setNumEntradas(-1);
		proy.setNombreInterno("Error");
		proy.setFecha("Error");
		proy.setHora(-1);
		proy.setId_sala(-1);
		proy.setId_pelicula(-1);
		proy.setPrecio(-1);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	@Test
	public void test2_crear_proyeccion2(){//intenta crear proy con sala invalida (error)
		TSalaNormal sala = new TSalaNormal();
		sala.setId(-1);
		sala.setAforo(100);
		sala.setNumero_sala(1);
		sala.setNum_anuncios(2);
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(1);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(2);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(1);
		proy.setId_pelicula(1);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	@Test
	public void test3_crear_proyeccion3(){//intenta crear proy con pelicula invalida (error)
		TSalaNormal sala = new TSalaNormal();
		sala.setId(1);
		sala.setAforo(100);
		sala.setNumero_sala(1);
		sala.setNum_anuncios(2);
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(-1);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(2);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(1);
		proy.setId_pelicula(1);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	@Test
	public void test4_crear_proyeccion4(){//proy valida con sala normal
		TSalaNormal sala = new TSalaNormal();
		sala.setId(1);
		sala.setAforo(100);
		sala.setNumero_sala(1);
		sala.setNum_anuncios(2);
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(1);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(2);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(1);
		proy.setId_pelicula(1);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":2,\"numEntradas\":100,\"nombreInterno\":\"3E19Titanic71630\",\"fecha\":\"03-01-2019\",\"hora\":1630,\"id_sala\":1,\"id_pelicula\":1,\"precio\":6}]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	
	@Test
	public void test5_crea_proyeccion5(){//proy valida con sala vip
		TSalaVip salaVip = new TSalaVip();
		salaVip.setId(1);
		salaVip.setAforo(100);
		salaVip.setNumero_sala(1);
		salaVip.setAdaptada(true);
		
		FactoriaNegocio.getInstance().hacerSASala().create(salaVip);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(1);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(2);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(1);
		proy.setId_pelicula(1);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":2,\"numEntradas\":100,\"nombreInterno\":\"3E19Titanic71630\",\"fecha\":\"03-01-2019\",\"hora\":1630,\"id_sala\":1,\"id_pelicula\":1,\"precio\":6}]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	
	
	@Test
	public void test6_crea_proyeccion6(){ //intenta guardar dos proy con mismo id (error)
		TSalaNormal sala = new TSalaNormal();
		sala.setId(1);
		sala.setAforo(100);
		sala.setNumero_sala(2);
		sala.setNum_anuncios(2);
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(2);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(1);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(1);
		proy.setId_pelicula(2);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		//proy con mismo id (no posible)
		TProyeccion proy2 = new TProyeccion();
		proy2.setID(1);
		proy2.setNumEntradas(100);
		proy2.setNombreInterno("3E19Titanic71630");
		proy2.setFecha("03-01-2019");
		proy2.setHora(1630);
		proy2.setId_sala(7);
		proy2.setId_pelicula(2);
		proy2.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy2);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":1,\"numEntradas\":100,\"nombreInterno\":\"3E19Titanic71630\",\"fecha\":\"03-01-2019\",\"hora\":1630,\"id_sala\":1,\"id_pelicula\":2,\"precio\":6}]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}

	@Test
	public void test7_crear_proyeccion7(){//guarda dos proyecciones con sala normal
		TSalaNormal sala = new TSalaNormal();
		sala.setId(7);
		sala.setAforo(100);
		sala.setNumero_sala(7);
		sala.setNum_anuncios(2);
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(2);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(1);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(7);
		proy.setId_pelicula(2);
		proy.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		TProyeccion proy2 = new TProyeccion();
		proy2.setID(2);
		proy2.setNumEntradas(80);
		proy2.setNombreInterno("3E19Titanic71230");
		proy2.setFecha("03-01-2019");
		proy2.setHora(1230);
		proy2.setId_sala(7);
		proy2.setId_pelicula(2);
		proy2.setPrecio(6);
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy2);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":1,\"numEntradas\":100,\"nombreInterno\":\"3E19Titanic71630\",\"fecha\":\"03-01-2019\",\"hora\":1630,\"id_sala\":7,\"id_pelicula\":2,\"precio\":6},"
				+ "{\"id\":2,\"numEntradas\":80,\"nombreInterno\":\"3E19Titanic71230\",\"fecha\":\"03-01-2019\",\"hora\":1230,\"id_sala\":7,\"id_pelicula\":2,\"precio\":6}]";
		
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	
	@Test
	public void test_8_crear_proyeccion8(){//guarda dos proyecciones con sala vip
		TSalaVip salaVip = new TSalaVip();
	    salaVip.setId(8);
	    salaVip.setAforo(120);
	    salaVip.setNumero_sala(8);
	    salaVip.setAdaptada(true);
	    FactoriaNegocio.getInstance().hacerSASala().create(salaVip);

	    TPelicula pelicula = new TPelicula();
	    pelicula.setId(3);
	    pelicula.setNombre("Matrix");
	    pelicula.setDuracion(140);
	    pelicula.setClasificacion("ficcion");
	    FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);

	    TProyeccion proy1 = new TProyeccion();
	    proy1.setID(3);
	    proy1.setNumEntradas(110);
	    proy1.setNombreInterno("5M25Matrix81700");
	    proy1.setFecha("05-05-2025");
	    proy1.setHora(1700);
	    proy1.setId_sala(8);
	    proy1.setId_pelicula(3);
	    proy1.setPrecio(10);
	    FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy1);

	    TProyeccion proy2 = new TProyeccion();
	    proy2.setID(4);
	    proy2.setNumEntradas(90);
	    proy2.setNombreInterno("5M25Matrix82000");
	    proy2.setFecha("05-05-2025");
	    proy2.setHora(2000);
	    proy2.setId_sala(8);
	    proy2.setId_pelicula(3);
	    proy2.setPrecio(10);
	    FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy2);

	    InputStream archivo = null;
	    try{
	    	archivo = new FileInputStream("resources/db/db.json");
	    }catch (FileNotFoundException e) {
	        fail();
	    }
	    
	    JSONObject json = new JSONObject(new JSONTokener(archivo));
        JSONArray proyecciones = json.getJSONArray("proyecciones");

	    String correcto = "[{\"id\":3,\"numEntradas\":110,\"nombreInterno\":\"5M25Matrix81700\",\"fecha\":\"05-05-2025\",\"hora\":1700,\"id_sala\":8,\"id_pelicula\":3,\"precio\":10}," +
                "{\"id\":4,\"numEntradas\":90,\"nombreInterno\":\"5M25Matrix82000\",\"fecha\":\"05-05-2025\",\"hora\":2000,\"id_sala\":8,\"id_pelicula\":3,\"precio\":10}]";

	    assertTrue(new JSONArray(correcto).similar(proyecciones));

	}
	
	@Test
	public void test9_eliminar_proyeccion1(){
		TSalaNormal sala = new TSalaNormal();
		sala.setId(7);
		sala.setAforo(100);
		sala.setNumero_sala(7);
		sala.setNum_anuncios(2);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula pelicula = new TPelicula();
		pelicula.setId(2);
		pelicula.setNombre("Titanic");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TPelicula pelicula2 = new TPelicula();
		pelicula2.setId(3);
		pelicula2.setNombre("Inception");
		pelicula2.setDuracion(120);
		pelicula2.setClasificacion("ficcion");

		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula2);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(1);
		proy.setNumEntradas(100);
		proy.setNombreInterno("3E19Titanic71630");
		proy.setFecha("03-01-2019");
		proy.setHora(1630);
		proy.setId_sala(7);
		proy.setId_pelicula(2);
		proy.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		TProyeccion proy2 = new TProyeccion();
		proy2.setID(2);
		proy2.setNumEntradas(80);
		proy2.setNombreInterno("3E19Inception71230");
		proy2.setFecha("03-01-2019");
		proy2.setHora(1230);
		proy2.setId_sala(7);
		proy2.setId_pelicula(3);
		proy2.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy2);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().delete(1);
		FactoriaNegocio.getInstance().hacerSAProyeccion().delete(2);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[]";
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	@Test
	public void test10_actualizar_proyeccion1(){//se actualiza correctamente
		TSalaNormal sala = new TSalaNormal();
		sala.setId(8);
		sala.setAforo(100);
		sala.setNumero_sala(2);
		sala.setNum_anuncios(2);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula peli = new TPelicula();
		peli.setId(3);
		peli.setNombre("Matrix");
		peli.setDuracion(220);
		peli.setClasificacion("15");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(peli);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(3);
		proy.setNumEntradas(100);
		proy.setNombreInterno("2F22Matrix71630");
		proy.setFecha("02-02-2022");
		proy.setHora(1630);
		proy.setId_sala(8);
		proy.setId_pelicula(3);
		proy.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		TProyeccion proyActualizado = new TProyeccion();
		proyActualizado.setID(3);
		proyActualizado.setNumEntradas(150);
		proyActualizado.setNombreInterno("2F22Matrix71830");
		proyActualizado.setFecha("02-02-2022");
		proyActualizado.setHora(1830);
		proyActualizado.setId_sala(8);
		proyActualizado.setId_pelicula(3);
		proyActualizado.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().update(proyActualizado);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":3,\"numEntradas\":150,\"nombreInterno\":\"2F22Matrix71830\",\"fecha\":\"02-02-2022\",\"hora\":1830,\"id_sala\":8,\"id_pelicula\":3,\"precio\":6}]";
	
		assertTrue(new JSONArray(correcto).similar(proyecciones));
	}
	
	@Test
	public void test11_actualiza_proyeccion2(){//no puede actualizar pq id introducido no esta en bd
		TSalaNormal sala = new TSalaNormal();
		sala.setId(8);
		sala.setAforo(100);
		sala.setNumero_sala(2);
		sala.setNum_anuncios(2);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala);
		
		TPelicula peli = new TPelicula();
		peli.setId(3);
		peli.setNombre("Matrix");
		peli.setDuracion(220);
		peli.setClasificacion("15");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(peli);
		
		TProyeccion proy = new TProyeccion();
		proy.setID(3);
		proy.setNumEntradas(100);
		proy.setNombreInterno("2F22Matrix71630");
		proy.setFecha("02-02-2022");
		proy.setHora(1630);
		proy.setId_sala(8);
		proy.setId_pelicula(3);
		proy.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proy);
		
		TProyeccion proyActualizado = new TProyeccion();
		proyActualizado.setID(2);
		proyActualizado.setNumEntradas(150);
		proyActualizado.setNombreInterno("2F22Matrix71830");
		proyActualizado.setFecha("02-02-2022");
		proyActualizado.setHora(1830);
		proyActualizado.setId_sala(8);
		proyActualizado.setId_pelicula(3);
		proyActualizado.setPrecio(6);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().update(proyActualizado);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		String correcto = "[{\"id\":3,\"numEntradas\":100,\"nombreInterno\":\"2F22Matrix71630\",\"fecha\":\"02-02-2022\",\"hora\":1630,\"id_sala\":8,\"id_pelicula\":3,\"precio\":6}]";
	
		assertTrue(new JSONArray(correcto).similar(proyecciones));
		
	}
	
	
	
	@After
	public void limpiar(){
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(1);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(2);
		
		FactoriaNegocio.getInstance().hacerSASala().delete(7);
		
		FactoriaNegocio.getInstance().hacerSASala().delete(1);
		
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(3);
		FactoriaNegocio.getInstance().hacerSASala().delete(8);
	}
	
	
}
