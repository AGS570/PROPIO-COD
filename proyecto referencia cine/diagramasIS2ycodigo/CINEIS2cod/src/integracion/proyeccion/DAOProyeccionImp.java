package integracion.proyeccion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.proyeccion.TProyeccion;

public class DAOProyeccionImp implements DAOProyeccion{

	@Override
	public int create(TProyeccion tProyeccion) {
		if(tProyeccion != null){
			
			int id = tProyeccion.getID();
			int numEntradas = tProyeccion.getNumEntradas();
			String nombreInterno = tProyeccion.getNombreInterno();
			String fecha= tProyeccion.getFecha();
			int hora = tProyeccion.getHora();
			int id_pelicula = tProyeccion.getId_pelicula();
			int id_sala = tProyeccion.getId_sala();
			double precio = tProyeccion.getPrecio();
			
			if(id != -1 && nombreInterno!= null && fecha != null && hora != -1 && id_sala != -1 && id_pelicula != -1 && precio != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("./resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray proyecciones = json.getJSONArray("proyecciones");
				
				JSONObject proy =new JSONObject();
				proy.put("id", id);
				proy.put("numEntradas", numEntradas);
				proy.put("nombreInterno", nombreInterno);
				proy.put("fecha", fecha);
				proy.put("hora", hora);
				proy.put("id_pelicula", id_pelicula);
				proy.put("id_sala", id_sala);
				proy.put("precio", precio);
				
				proyecciones.put(proy);
				
				try{
					OutputStream escritura = new FileOutputStream("./resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				}catch(IOException e){
					System.err.print("ERROR: fallo de escritura en base de datos");
					return -1;
				}
				return id;
			}	
		}
		return -1;
	}

	@Override
	public TProyeccion read(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("./resources/db/db.json");
			}catch(FileNotFoundException e){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray proyecciones = json.getJSONArray("proyecciones");
			
			int i = 0;
			boolean encontrado = false;
			while (encontrado != true && i < proyecciones.length()){
				JSONObject proy = proyecciones.getJSONObject(i);
				if(proy.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				JSONObject datos = proyecciones.getJSONObject(i);
				TProyeccion proyeccion = new TProyeccion();
				proyeccion.setID(datos.getInt("id"));
				proyeccion.setNumEntradas(datos.getInt("numEntradas"));
				proyeccion.setNombreInterno(datos.getString("nombreInterno"));
				proyeccion.setFecha(datos.getString("fecha"));
				proyeccion.setHora(datos.getInt("hora"));
				proyeccion.setId_sala(datos.getInt("id_sala"));
				proyeccion.setId_pelicula(datos.getInt("id_pelicula"));
				proyeccion.setPrecio(datos.getDouble("precio"));
				return proyeccion;
			}	
		}
		return null;
	}

	@Override
	public TProyeccion[] readAll() {
		InputStream archivo;
		try{
			archivo = new FileInputStream("./resources/db/db.json");
		}catch(FileNotFoundException e){
			System.err.print("ERROR: base de datos no encontrada");
			return null;
		}
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray proyecciones = json.getJSONArray("proyecciones");
		
		TProyeccion[] listaProyecciones = null;
		
		if(proyecciones.length() > 0){
			listaProyecciones = new TProyeccion[proyecciones.length()];
			
			for(int i = 0; i < proyecciones.length(); i++){
				JSONObject datos = proyecciones.getJSONObject(i);
				listaProyecciones[i] = new TProyeccion();
				listaProyecciones[i].setID(datos.getInt("id"));
				listaProyecciones[i].setNumEntradas(datos.getInt("numEntradas"));
				listaProyecciones[i].setNombreInterno(datos.getString("nombreInterno"));
				listaProyecciones[i].setFecha(datos.getString("fecha"));
				listaProyecciones[i].setHora(datos.getInt("hora"));
				listaProyecciones[i].setId_sala(datos.getInt("id_sala"));
				listaProyecciones[i].setId_pelicula(datos.getInt("id_pelicula"));
				listaProyecciones[i].setPrecio(datos.getInt("precio"));
			}
		}
		return listaProyecciones;
	}

	@Override
	public TProyeccion[] readAllBySala(int id_sala) {
		List<TProyeccion> listaProyecciones = new ArrayList<>();
		if(id_sala != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("./resources/db/db.json");
			}catch(FileNotFoundException e){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray proyecciones = json.getJSONArray("proyecciones");
		
			if(proyecciones.length() > 0){
				for(int i = 0; i < proyecciones.length(); i++){
					JSONObject datos = proyecciones.getJSONObject(i);
					if(datos.getInt("id_sala") == id_sala){
						TProyeccion tp = new TProyeccion();
						
						tp.setID(datos.getInt("id"));
						tp.setNumEntradas(datos.getInt("numEntradas"));
						tp.setNombreInterno(datos.getString("nombreInterno"));
						tp.setFecha(datos.getString("fecha"));
						tp.setHora(datos.getInt("hora"));
					    tp.setId_sala(datos.getInt("id_sala"));
						tp.setId_pelicula(datos.getInt("id_pelicula"));
						tp.setPrecio(datos.getDouble("precio"));
						
						listaProyecciones.add(tp);
					}
				}
			}
		}
		return listaProyecciones.toArray(new TProyeccion[listaProyecciones.size()]);
	}

	@Override
	public TProyeccion[] readAllByPelicula(int id_pelicula) {
		List<TProyeccion> listaProyecciones = new ArrayList<>();
		if(id_pelicula != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("./resources/db/db.json");
			}catch(FileNotFoundException e){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray proyecciones = json.getJSONArray("proyecciones");
		
			if(proyecciones.length() > 0){
				for(int i = 0; i < proyecciones.length(); i++){
					JSONObject datos = proyecciones.getJSONObject(i);
					if(datos.getInt("id_pelicula") == id_pelicula){
						TProyeccion tp = new TProyeccion();
						
						tp.setID(datos.getInt("id"));
						tp.setNumEntradas(datos.getInt("numEntradas"));
						tp.setNombreInterno(datos.getString("nombreInterno"));
						tp.setFecha(datos.getString("fecha"));
						tp.setHora(datos.getInt("hora"));
					    tp.setId_sala(datos.getInt("id_sala"));
						tp.setId_pelicula(datos.getInt("id_pelicula"));
						tp.setPrecio(datos.getDouble("precio"));
						
						listaProyecciones.add(tp);
					}
				}
			
			}
		}
		return listaProyecciones.toArray(new TProyeccion[listaProyecciones.size()]);
	}

	@Override
	public int update(TProyeccion tProyeccion) {
		if(tProyeccion != null){
			int id = tProyeccion.getID();
			int numEntradas = tProyeccion.getNumEntradas();
			String nombreInterno = tProyeccion.getNombreInterno();
			String fecha = tProyeccion.getFecha();
			int hora = tProyeccion.getHora();
			int id_sala = tProyeccion.getId_sala();
			int id_pelicula = tProyeccion.getId_pelicula();
			double precio = tProyeccion.getPrecio();
			
			if(id != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("./resources/db/db.json");
				}catch(FileNotFoundException e){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray proyecciones = json.getJSONArray("proyecciones");
				
				boolean encontrado = false;
				int i = 0;
				while(!encontrado && i < proyecciones.length()){
					JSONObject datos = proyecciones.getJSONObject(i);
					if(datos.getInt("id") == id) 
						encontrado = true;
					else i++;
				}
				
				if(encontrado){
					JSONObject proy = proyecciones.getJSONObject(i);
					
					if(numEntradas >= 0)
						proy.put("numEntradas", numEntradas);
					if(nombreInterno != null)
						proy.put("nombreInterno", nombreInterno);
					if(fecha != null)
						proy.put("fecha", fecha);
					if(hora != -1)
						proy.put("hora", hora);
					if(id_sala != -1)
						proy.put("id_sala", id_sala);
					if(id_pelicula != -1)
						proy.put("id_pelicula", id_pelicula);
					if(precio != -1)
						proy.put("precio", precio);
					
					try{
						OutputStream escritura = new FileOutputStream("./resources/db/db.json");
						escritura.write(json.toString().getBytes());
						escritura.close();
					}catch(IOException e){
						System.err.print("ERROR: fallo de escritura en base de datos");
						return -1;					
					}
					return id;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean delete(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("./resources/db/db.json");
			}catch(FileNotFoundException e){
				System.err.print("ERROR: base de datos no encontrada");
				return false;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray proyecciones = json.getJSONArray("proyecciones");
			
			int i = 0;
			boolean encontrado = false;
			while(!encontrado && i < proyecciones.length()){
				JSONObject proy = proyecciones.getJSONObject(i);
				if(proy.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				proyecciones.remove(i);
				
				try{
					OutputStream escritura = new FileOutputStream("./resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				}catch(IOException e){
					System.err.print("ERROR: fallo de borrado en base de datos");
					return false;
				}
				return true;
			}
		}
		return false;
	}

}
