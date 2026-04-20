package integracion.venta;

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

import negocio.venta.TLineaVenta;

public class DAOLineasVentaImp implements DAOLineasVenta {
	
	public int create(TLineaVenta tLineaVenta) {
		if (tLineaVenta != null){
			int idlineaVenta = tLineaVenta.getIdVenta();
			int cantidadEntradas = tLineaVenta.getCantidadEntradas();
			int idProyeccion = tLineaVenta.getIdProyeccion();
			if(idlineaVenta != -1 && idProyeccion != -1 && cantidadEntradas != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray lineasVenta = json.getJSONArray("lineasVenta");
				
				JSONObject lineaVenta = new JSONObject();
				lineaVenta.put("idlineaVenta", idlineaVenta);
				lineaVenta.put("cantidadEntradas", cantidadEntradas);
				lineaVenta.put("idProyeccion", idProyeccion);
				
				lineasVenta.put(lineaVenta);
				
				try{
					OutputStream escritura = new FileOutputStream("./resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				}catch(IOException ex){
					System.err.print("ERROR: fallo de escritura en base de datos");
					return -1;
				}
				
				return idlineaVenta;
			}
		}
		return -1;
	}


	public boolean deleteAllById(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return false;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray lineasVenta = json.getJSONArray("lineasVenta");

			for(int i = 0; i < lineasVenta.length(); i++){
				JSONObject peli = lineasVenta.getJSONObject(i);
				if(peli.getInt("idlineaVenta") == id){
					lineasVenta.remove(i);

				}
			}
			
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
		return false;
	}


	public TLineaVenta[] readAllByID(int id) {
		List<TLineaVenta> listaVentas = new ArrayList<TLineaVenta>();
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray lineaVentas = json.getJSONArray("lineasVenta");	
			
			if(lineaVentas.length() > 0){
				for(int i = 0; i < lineaVentas.length(); i++){
					JSONObject datos = lineaVentas.getJSONObject(i);
					if(datos.getInt("idlineaVenta") == id){
						TLineaVenta tl = new TLineaVenta();

						tl.setIdVenta(datos.getInt("idlineaVenta"));
						tl.setCantidadEntradas(datos.getInt("cantidadEntradas"));
						tl.setIdProyeccion(datos.getInt("idProyeccion"));
						
						listaVentas.add(tl);
					}
				}
			}
		}
		if(listaVentas.size() > 0){
			return listaVentas.toArray(new TLineaVenta[listaVentas.size()]);
		}else{
			return null;
		}
	}
}

