package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import negocio.FactoriaNegocio;
import negocio.empleado.TEmpleado;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEmpleados {
	
	
	@Test
	public void test1_crear_Empleado(){
		
		TEmpleado empleado = new TEmpleado();
		empleado.setId(-1);
		empleado.setnif(-1);
		empleado.setNombre("Error");
		empleado.setSalario(-1);
		empleado.setnumTaquilla(-1);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		String correcto = "[]";
		
		assertTrue(new JSONArray(correcto).similar(empleados));
		
	}
	@Test
public void test2_crear_Empleado(){
		//mismo id
		TEmpleado empleado = new TEmpleado();
		empleado.setId(10);
		empleado.setnif(11);
		empleado.setNombre("Error");
		empleado.setSalario(120);
		empleado.setnumTaquilla(100);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TEmpleado empleado2 = new TEmpleado();
		empleado2.setId(10);
		empleado2.setnif(67);
		empleado2.setNombre("Error2");
		empleado2.setSalario(1000);
		empleado2.setnumTaquilla(101);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado2);
		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		String correcto = "[{\"salario\":120,\"numero_taquilla\":100,\"nif\":11,\"id\":10,\"nombre\":\"Error\"}]";
		
		assertTrue(new JSONArray(correcto).similar(empleados));
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(10);
		 
	}
	@Test
	public void test3_crear_Empleado(){
		//numtaquilla no existente
		TEmpleado empleado = new TEmpleado();
		empleado.setId(10);
		empleado.setnif(11);
		empleado.setNombre("Error");
		empleado.setSalario(120);
		empleado.setnumTaquilla(-1);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		String correcto = "[]";
		assertTrue(new JSONArray(correcto).similar(empleados));
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(10);	
	}
	
	
	@Test
	public void test4_actualizar_Empleado(){
		//actualiza correctamente
		TEmpleado empleado = new TEmpleado();
		empleado.setId(10);
		empleado.setnif(11);
		empleado.setNombre("Error");
		empleado.setSalario(120);
		empleado.setnumTaquilla(101);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		TEmpleado empleado2 = new TEmpleado();
		empleado2.setId(10);
		empleado2.setNombre("Error2");
		empleado2.setSalario(125);
		empleado2.setnumTaquilla(102);
		FactoriaNegocio.getInstance().hacerSAEmpleado().update(empleado2);

		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		

		String correcto = "[{\"salario\":125,\"numero_taquilla\":102,\"nif\":11,\"id\":10,\"nombre\":\"Error2\"}]";
		assertTrue(new JSONArray(correcto).similar(empleados));
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(10);	
		
		
	}
	
	 @Test
	public void test5_actualizar_Empleado(){
		 //actualiza con id incorrecto
		TEmpleado empleado = new TEmpleado();
		empleado.setId(10);
		empleado.setnif(11);
		empleado.setNombre("Margaret");
		empleado.setSalario(120);
		empleado.setnumTaquilla(101);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TEmpleado empleado2 = new TEmpleado();
		empleado2.setId(11);
		empleado2.setNombre("Eusebio");
		empleado2.setnumTaquilla(102);
		FactoriaNegocio.getInstance().hacerSAEmpleado().update(empleado2);
		

		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		String correcto = "[{\"salario\":120,\"numero_taquilla\":101,\"nif\":11,\"id\":10,\"nombre\":\"Margaret\"}]";
	
		assertTrue(new JSONArray(correcto).similar(empleados));
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(10);	
		
	}
	 
	@Test
	public void test6_eliminar_Empleado(){
		//se elimina correctamente
		TEmpleado empleado = new TEmpleado();
		empleado.setId(10);
		empleado.setnif(1143);
		empleado.setNombre("Julio");
		empleado.setSalario(1250);
		empleado.setnumTaquilla(101);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		TEmpleado empleado2 = new TEmpleado();
		empleado2.setId(11);
		empleado2.setnif(1144);
		empleado2.setNombre("Teresa");
		empleado2.setSalario(1250);
		empleado2.setnumTaquilla(102);
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado2);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(10);	
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(11);	
		
		InputStream archivo = null;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException e){
			fail();
		}
		
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		

		String correcto = "[]";
		assertTrue(new JSONArray(correcto).similar(empleados));

		
	}
	 
}
