package integracion.pelicula;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.pelicula.TPelicula;

public class DAOPeliculaImp implements DAOPelicula {

	public int create(TPelicula tPelicula) {
		if(tPelicula != null){
			int id = tPelicula.getId();
			String nombre= tPelicula.getNombre();
			int duracion = tPelicula.getDuracion();
			String clasif = tPelicula.getClasificacion();
			
			if(id != -1 && nombre != null && duracion != -1 && clasif != null){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray peliculas = json.getJSONArray("peliculas");
				
				JSONObject peli = new JSONObject();
				peli.put("id", id);
				peli.put("nombre", nombre);
				peli.put("duracion", duracion);
				peli.put("clasificacion", clasif);
				
				peliculas.put(peli);

				try{
					OutputStream escritura = new FileOutputStream("./resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				}catch(IOException ex){
					System.err.print("ERROR: fallo de escritura en base de datos");
					return -1;
				}
				
				return id;
			}
		}
		return -1;
	}

	public int update(TPelicula tPelicula) {
		if(tPelicula != null){
			int id = tPelicula.getId();
			String nombre= tPelicula.getNombre();
			int duracion = tPelicula.getDuracion();
			String clasif = tPelicula.getClasificacion();
			
			if(id != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray peliculas = json.getJSONArray("peliculas");
				
				int i = 0;
				boolean encontrado = false; 
				while(!encontrado && i < peliculas.length()){
					JSONObject peli = peliculas.getJSONObject(i);
					if(peli.getInt("id") == id)
						encontrado = true;
					else i++;
				}

				if(encontrado){
					JSONObject peli = peliculas.getJSONObject(i);
					
					if(nombre != null)
						peli.put("nombre", nombre);
					
					if(duracion != -1)
						peli.put("duracion", duracion);
					
					if(clasif != null)
						peli.put("clasificacion", clasif);

					try{
						OutputStream escritura = new FileOutputStream("resources/db/db.json");
						escritura.write(json.toString().getBytes());
						escritura.close();
					}catch(IOException ex){
						System.err.print("ERROR: fallo de escritura en base de datos");
						return -1;
					}
					
					return id;
				}
			}
		}
		return -1;
	}

	public boolean delete(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return false;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray peliculas = json.getJSONArray("peliculas");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < peliculas.length()){
				JSONObject peli = peliculas.getJSONObject(i);
				if(peli.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				peliculas.remove(i);

				try{
					OutputStream escritura = new FileOutputStream("resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				}catch(IOException ex){
					System.err.print("ERROR: fallo de borrado en base de datos");
					return false;
				}
				
				return true;
			}
		}
		return false;
	}

	public TPelicula read(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray peliculas = json.getJSONArray("peliculas");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < peliculas.length()){
				JSONObject peli = peliculas.getJSONObject(i);
				if(peli.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				JSONObject datos = peliculas.getJSONObject(i);
				TPelicula pelicula = new TPelicula();
				pelicula.setId(datos.getInt("id"));
				pelicula.setNombre(datos.getString("nombre"));
				pelicula.setDuracion(datos.getInt("duracion"));
				pelicula.setClasificacion(datos.getString("clasificacion"));
				return pelicula;
			}
		}
		return null;
	}

	public TPelicula[] readAll() {
		InputStream archivo;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException ex){
			System.err.print("ERROR: base de datos no encontrada");
			return null;
		}
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray peliculas = json.getJSONArray("peliculas");
		
		TPelicula[] listaPeliculas = null;
		
		if(peliculas.length() > 0){
			listaPeliculas = new TPelicula[peliculas.length()];

			for(int i = 0; i < peliculas.length(); i++){
				JSONObject datos = peliculas.getJSONObject(i);
				listaPeliculas[i] = new TPelicula();
				listaPeliculas[i].setId(datos.getInt("id"));
				listaPeliculas[i].setNombre(datos.getString("nombre"));
				listaPeliculas[i].setDuracion(datos.getInt("duracion"));
				listaPeliculas[i].setClasificacion(datos.getString("clasificacion"));
			}
		}
		return listaPeliculas;
	}

}
