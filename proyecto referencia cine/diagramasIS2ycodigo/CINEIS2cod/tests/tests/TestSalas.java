package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import negocio.sala.TSalaNormal;
import negocio.sala.TSalaVip;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSalas {

	@Test
	public void test1_crear_sala_normal1(){
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(-1);
		sala_normal.setAforo(100);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(2);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray salas = json.getJSONArray("salas");

		String correcto = "[]";
	
		
		assertTrue(new JSONArray(correcto).similar(salas));
		
	}
	
	@Test
	public void test2_crear_sala_normal2(){
	
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(10);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(2);
		sala_normal.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"numero_anuncios\":4,\"id\":10,\"numero_sala\":2,\"tipo\":\"normal\",\"aforo\":50}]";
		

		assertTrue(new JSONArray(correcto).similar(resultado));
			
	
	
	}
	
	
	@Test
	public void test3_crear_sala_normal3(){
		
		TSalaNormal sala_normal1 = new TSalaNormal();
		
		sala_normal1.setId(10);
		sala_normal1.setAforo(50);
		sala_normal1.setNumero_sala(2);
		sala_normal1.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal1);


		TSalaNormal sala_normal2 = new TSalaNormal();
		
		sala_normal2.setId(10);
		sala_normal2.setAforo(0);
		sala_normal2.setNumero_sala(2);
		sala_normal2.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal2);

		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");
		

		String correcto = "[{\"numero_anuncios\":4,\"id\":10,\"numero_sala\":2,\"tipo\":\"normal\",\"aforo\":50}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test4_crear_sala_normal4(){
		
		TSalaNormal sala_normal1 = new TSalaNormal();
		
		sala_normal1.setId(10);
		sala_normal1.setAforo(50);
		sala_normal1.setNumero_sala(2);
		sala_normal1.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal1);


		TSalaNormal sala_normal2 = new TSalaNormal();
		
		sala_normal2.setId(5);
		sala_normal2.setAforo(65);
		sala_normal2.setNumero_sala(3);
		sala_normal2.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal2);

		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");
		

		String correcto = "[{\"numero_anuncios\":4,\"id\":10,\"numero_sala\":2,\"tipo\":\"normal\",\"aforo\":50},{\"numero_anuncios\":4,\"id\":5,\"numero_sala\":3,\"tipo\":\"normal\",\"aforo\":65}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test5_crea_sala_vip1(){
		
		TSalaVip sala_vip = new TSalaVip();
		
		sala_vip.setId(-1);
		sala_vip.setAforo(-1);
		sala_vip.setNumero_sala(-1);
		sala_vip.setAdaptada(false);
		

		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	
	@Test
	public void test6_crea_sala_vip2(){
		
		TSalaVip sala_vip = new TSalaVip();
		
		sala_vip.setId(3);
		sala_vip.setAforo(40);
		sala_vip.setNumero_sala(6);
		sala_vip.setAdaptada(true);
		

		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"adaptada\":true,\"id\":3,\"numero_sala\":6,\"tipo\":\"vip\",\"aforo\":40}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	
	@Test
	public void test7_crea_sala_vip3(){
		
		TSalaVip sala_vip1 = new TSalaVip();
		
		sala_vip1.setId(3);
		sala_vip1.setAforo(40);
		sala_vip1.setNumero_sala(6);
		sala_vip1.setAdaptada(true);
	
		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip1);
		
		TSalaVip sala_vip2 = new TSalaVip();
		
		sala_vip2.setId(3);
		sala_vip2.setAforo(0);
		sala_vip2.setNumero_sala(6);
		sala_vip2.setAdaptada(true);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip2);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"adaptada\":true,\"id\":3,\"numero_sala\":6,\"tipo\":\"vip\",\"aforo\":40}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	@Test

	public void test8_crea_sala_vip4(){
		
		TSalaVip sala_vip1 = new TSalaVip();
		
		sala_vip1.setId(3);
		sala_vip1.setAforo(40);
		sala_vip1.setNumero_sala(6);
		sala_vip1.setAdaptada(true);
	
		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip1);
		
		TSalaVip sala_vip2 = new TSalaVip();
		
		sala_vip2.setId(8);
		sala_vip2.setAforo(65);
		sala_vip2.setNumero_sala(9);
		sala_vip2.setAdaptada(true);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip2);
		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"adaptada\":true,\"id\":3,\"numero_sala\":6,\"tipo\":\"vip\",\"aforo\":40},{\"adaptada\":true,\"id\":8,\"numero_sala\":9,\"tipo\":\"vip\",\"aforo\":65}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	

	
	@Test
	public void test9_eliminar_sala(){
		
		TSalaVip sala_vip1 = new TSalaVip();
		
		sala_vip1.setId(1);
		sala_vip1.setAforo(40);
		sala_vip1.setNumero_sala(6);
		sala_vip1.setAdaptada(true);
	
		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip1);
		
		TSalaNormal sala_normal1 = new TSalaNormal();
		
		sala_normal1.setId(2);
		sala_normal1.setAforo(50);
		sala_normal1.setNumero_sala(2);
		sala_normal1.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal1);
		
		FactoriaNegocio.getInstance().hacerSASala().delete(1);
		FactoriaNegocio.getInstance().hacerSASala().delete(2);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	@Test
	public void test10_actualizar_sala_normal1(){
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(10);
		sala_normal.setAforo(500);
		sala_normal.setNumero_sala(2);
		sala_normal.setNum_anuncios(40);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TSalaNormal actualizacion = new TSalaNormal();
		actualizacion.setId(10);
		actualizacion.setAforo(50);
		actualizacion.setNum_anuncios(4);

		FactoriaNegocio.getInstance().hacerSASala().update(actualizacion);

		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"numero_anuncios\":4,\"id\":10,\"numero_sala\":2,\"tipo\":\"normal\",\"aforo\":50}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	

	@Test
	public void actualizar_sala_normal2(){
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(10);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(2);
		sala_normal.setNum_anuncios(4);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TSalaNormal actualizacion = new TSalaNormal();
		actualizacion.setAforo(0);
		actualizacion.setNumero_sala(0);
		actualizacion.setNum_anuncios(0);

		FactoriaNegocio.getInstance().hacerSASala().update(actualizacion);

		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"numero_anuncios\":4,\"id\":10,\"numero_sala\":2,\"tipo\":\"normal\",\"aforo\":50}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	@Test
	public void actualizar_sala_vip1(){

		TSalaVip sala_vip = new TSalaVip();
		
		sala_vip.setId(3);
		sala_vip.setAforo(400);
		sala_vip.setNumero_sala(600);
		sala_vip.setAdaptada(true);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip);		
		
		TSalaVip actualizacion = new TSalaVip();
		
		actualizacion.setId(3);
		actualizacion.setAforo(40);
		actualizacion.setNumero_sala(6);
		
		FactoriaNegocio.getInstance().hacerSASala().update(actualizacion);

		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"adaptada\":true,\"id\":3,\"numero_sala\":6,\"tipo\":\"vip\",\"aforo\":40}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}
	
	@Test
	public void actualizar_sala_vip2(){

		TSalaVip sala_vip = new TSalaVip();
		
		sala_vip.setId(3);
		sala_vip.setAforo(40);
		sala_vip.setNumero_sala(6);
		sala_vip.setAdaptada(true);
		
		FactoriaNegocio.getInstance().hacerSASala().create(sala_vip);		
		
		TSalaVip actualizacion = new TSalaVip();
		
		actualizacion.setId(99);
		actualizacion.setAforo(0);
		actualizacion.setNumero_sala(0);
		sala_vip.setAdaptada(false);

		FactoriaNegocio.getInstance().hacerSASala().update(actualizacion);

		
		InputStream archivo = null;
		
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("salas");

		String correcto = "[{\"adaptada\":true,\"id\":3,\"numero_sala\":6,\"tipo\":\"vip\",\"aforo\":40}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
		
	}


	@After
	public void limpiar(){
		FactoriaNegocio.getInstance().hacerSASala().delete(3);
		FactoriaNegocio.getInstance().hacerSASala().delete(10);
		FactoriaNegocio.getInstance().hacerSASala().delete(5);
		FactoriaNegocio.getInstance().hacerSASala().delete(8);


		
	}

	

}
