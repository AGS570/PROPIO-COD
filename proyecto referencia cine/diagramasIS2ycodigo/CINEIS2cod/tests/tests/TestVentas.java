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

import integracion.FactoriaIntegracion;
import negocio.FactoriaNegocio;
import negocio.empleado.TEmpleado;
import negocio.pelicula.TPelicula;
import negocio.proyeccion.TProyeccion;
import negocio.sala.TSalaNormal;
import negocio.venta.TCarrito;
import negocio.venta.TLineaVenta;
import negocio.venta.TVenta;


// Realizar sobre un archivo JSON sin datos para que no influyan los resultados

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestVentas {
	
	@Test
	public void test1_abrir_venta1() {	
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(100);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		try{
			TCarrito.aniadirLineaVenta(lineaVenta);
		}
		
		catch (NullPointerException ne){}
		
		assertTrue(TCarrito.getCantidad() == 0);
	}
	
	@Test
	public void test2_abrir_venta2() {	
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(100);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		try{
			TCarrito.aniadirLineaVenta(lineaVenta);
			FactoriaIntegracion.getInstance().hacerDAOLineasVenta().create(lineaVenta);
		}
		
		catch (NullPointerException ne){}
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("lineasVenta");

		String correcto = "[{\"cantidadEntradas\":1,\"idlineaVenta\":1,\"idProyeccion\":100}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	
	@Test
	public void test3_aniadir_venta1() {	
		
		TEmpleado empleado = new TEmpleado();
		
		empleado.setId(1);
		empleado.setNombre("Paco");
		empleado.setnif(12345);
		empleado.setnumTaquilla(1);
		empleado.setSalario(1000);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(1);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(1);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proyeccion = new TProyeccion();
		
		proyeccion.setFecha("01/01/2000");
		proyeccion.setHora(1630);
		proyeccion.setID(1);
		proyeccion.setId_pelicula(1);
		proyeccion.setId_sala(1);
		proyeccion.setNombreInterno("test");
		proyeccion.setNumEntradas(10);
		proyeccion.setPrecio(5.99);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proyeccion);
		
		TVenta venta = new TVenta();
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(1);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		
		venta.setId(1);
		venta.setID_Vendedor(1);
		venta.setFecha_Compra("01/01/2000");
		
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta);
		
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("ventas");

		String correcto = "[{\"fechaCompra\":\"01/01/2000\",\"precio\":5.99,\"idVendedor\":1,\"id\":1}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test4_aniadir_venta2() {	
		
		TEmpleado empleado = new TEmpleado();
		
		empleado.setId(1);
		empleado.setNombre("Paco");
		empleado.setnif(12345);
		empleado.setnumTaquilla(1);
		empleado.setSalario(1000);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(1);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(1);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proyeccion = new TProyeccion();
		
		proyeccion.setFecha("01/01/2000");
		proyeccion.setHora(1630);
		proyeccion.setID(1);
		proyeccion.setId_pelicula(1);
		proyeccion.setId_sala(1);
		proyeccion.setNombreInterno("test");
		proyeccion.setNumEntradas(10);
		proyeccion.setPrecio(5.99);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proyeccion);
		
		TVenta venta = new TVenta();
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(1);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		
		venta.setId(1);
		
		venta.setID_Vendedor(2); // no existe vendedor
		
		venta.setFecha_Compra("01/01/2000");
		
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta);
		
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("ventas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test5_aniadir_venta3() {	
		
		TEmpleado empleado = new TEmpleado();
		
		empleado.setId(1);
		empleado.setNombre("Paco");
		empleado.setnif(12345);
		empleado.setnumTaquilla(1);
		empleado.setSalario(1000);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(1);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(1);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proyeccion = new TProyeccion();
		
		proyeccion.setFecha("01/01/2000");
		proyeccion.setHora(1630);
		proyeccion.setID(1);
		proyeccion.setId_pelicula(1);
		proyeccion.setId_sala(1);
		proyeccion.setNombreInterno("test");
		proyeccion.setNumEntradas(10);
		proyeccion.setPrecio(5.99);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proyeccion);
		
		TVenta venta = new TVenta();
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(1);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		
		venta.setId(1);
		venta.setID_Vendedor(1);
		venta.setFecha_Compra("01/01/2000");
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta);
		
		TVenta venta_repetida = new TVenta();
		
		venta.setId(1);
		venta.setID_Vendedor(1);
		venta.setFecha_Compra("01/01/2000");
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta_repetida);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("ventas");

		String correcto = "[{\"fechaCompra\":\"01/01/2000\",\"precio\":5.99,\"idVendedor\":1,\"id\":1}]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test6_devolver_venta() {	
		
		TEmpleado empleado = new TEmpleado();
		
		empleado.setId(1);
		empleado.setNombre("Paco");
		empleado.setnif(12345);
		empleado.setnumTaquilla(1);
		empleado.setSalario(1000);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(1);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(1);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proyeccion = new TProyeccion();
		
		proyeccion.setFecha("01/01/2000");
		proyeccion.setHora(1630);
		proyeccion.setID(1);
		proyeccion.setId_pelicula(1);
		proyeccion.setId_sala(1);
		proyeccion.setNombreInterno("test");
		proyeccion.setNumEntradas(10);
		proyeccion.setPrecio(5.99);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proyeccion);
		
		TVenta venta = new TVenta();
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(1);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		
		venta.setId(1);
		venta.setID_Vendedor(1);
		venta.setFecha_Compra("01/01/2000");
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta);
		
		FactoriaNegocio.getInstance().hacerSAVenta().devolver(1);
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("ventas");

		String correcto = "[]";

		assertTrue(new JSONArray(correcto).similar(resultado));
	}
	
	@Test
	public void test7_eliminar_venta() {	
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(100);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		TCarrito.eliminarLineaVenta();
		TCarrito.eliminarLineaVenta();

		assertTrue(TCarrito.getCantidad() == 0);
	}
	
	@Test
	public void test8_cerrar_venta() {	
		
		TEmpleado empleado = new TEmpleado();
		
		empleado.setId(1);
		empleado.setNombre("Paco");
		empleado.setnif(12345);
		empleado.setnumTaquilla(1);
		empleado.setSalario(1000);
		
		FactoriaNegocio.getInstance().hacerSAEmpleado().create(empleado);
		
		TSalaNormal sala_normal = new TSalaNormal();
		
		sala_normal.setId(1);
		sala_normal.setAforo(50);
		sala_normal.setNumero_sala(1);
		sala_normal.setNum_anuncios(1);

		FactoriaNegocio.getInstance().hacerSASala().create(sala_normal);
		
		TPelicula pelicula = new TPelicula();

		pelicula.setId(1);
		pelicula.setNombre("Star Wars");
		pelicula.setDuracion(120);
		pelicula.setClasificacion("Intergalactico");
		
		FactoriaNegocio.getInstance().hacerSAPelicula().create(pelicula);
		
		TProyeccion proyeccion = new TProyeccion();
		
		proyeccion.setFecha("01/01/2000");
		proyeccion.setHora(1630);
		proyeccion.setID(1);
		proyeccion.setId_pelicula(1);
		proyeccion.setId_sala(1);
		proyeccion.setNombreInterno("test");
		proyeccion.setNumEntradas(10);
		proyeccion.setPrecio(5.99);
		
		FactoriaNegocio.getInstance().hacerSAProyeccion().create(proyeccion);
		
		TVenta venta = new TVenta();
		
		TCarrito.nuevo_carrito();
		
		TLineaVenta lineaVenta = new TLineaVenta();
		
		lineaVenta.setIdProyeccion(1);
		lineaVenta.setCantidadEntradas(1);
		lineaVenta.setIdVenta(1);
		
		TCarrito.aniadirLineaVenta(lineaVenta);
		
		venta.setId(1);
		venta.setID_Vendedor(1);
		venta.setFecha_Compra("01/01/2000");
		
		
		FactoriaNegocio.getInstance().hacerSAVenta().create(venta);
		TCarrito.nuevo_carrito();
		
		InputStream archivo = null;
		try {
			archivo = new FileInputStream("resources/db/db.json");

		} catch (FileNotFoundException ex) {
			fail();
		}

		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray resultado = json.getJSONArray("ventas");

		String correcto = "[{\"fechaCompra\":\"01/01/2000\",\"precio\":5.99,\"idVendedor\":1,\"id\":1}]";

		assertTrue(new JSONArray(correcto).similar(resultado) && TCarrito.getCantidad() == 0);
	}
	
	@After
	public void limpiar(){
		FactoriaIntegracion.getInstance().hacerDAOVenta().delete(1);
		FactoriaIntegracion.getInstance().hacerDAOLineasVenta().deleteAllById(1);
		FactoriaNegocio.getInstance().hacerSAEmpleado().delete(1);
		FactoriaNegocio.getInstance().hacerSAPelicula().delete(1);
		FactoriaNegocio.getInstance().hacerSAProyeccion().delete(1);
		FactoriaNegocio.getInstance().hacerSASala().delete(1);
	}
}