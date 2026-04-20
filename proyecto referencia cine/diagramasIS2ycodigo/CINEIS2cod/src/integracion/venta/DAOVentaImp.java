package integracion.venta;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.venta.TVenta;


public class DAOVentaImp implements DAOVenta {
	
	public int create(TVenta tVenta) {
		if(tVenta != null){
			int id = tVenta.getId();
			int idVendedor = tVenta.getID_Vendedor();
			String fCompra = tVenta.getFecha_Compra();
			double precio = tVenta.getPrecio();
			
			if(id != -1 && idVendedor != -1 && fCompra != null && precio != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray ventas = json.getJSONArray("ventas");
				
				JSONObject venta = new JSONObject();
				venta.put("id", id);
				venta.put("idVendedor", idVendedor);
				venta.put("fechaCompra", fCompra);
				venta.put("precio", precio);
				
				ventas.put(venta);
				
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
			JSONArray ventas = json.getJSONArray("ventas");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < ventas.length()){
				JSONObject venta = ventas.getJSONObject(i);
				if(venta.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				ventas.remove(i);

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

	
	public TVenta read(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray ventas = json.getJSONArray("ventas");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < ventas.length()){
				JSONObject venta = ventas.getJSONObject(i);
				if(venta.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				JSONObject datos = ventas.getJSONObject(i);
				TVenta venta = new TVenta();
				venta.setId(datos.getInt("id"));
				venta.setID_Vendedor(datos.getInt("idVendedor"));
				venta.setFecha_Compra(datos.getString("fechaCompra"));
				venta.setPrecio(datos.getDouble("precio"));
				return venta;
			}
		}
		return null;
	}

	public TVenta[] readAll() {
		InputStream archivo;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException ex){
			System.err.print("ERROR: base de datos no encontrada");
			return null;
		}
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray ventas = json.getJSONArray("ventas");
		
		TVenta[] listaventas = null;
		
		if(ventas.length() > 0){
			listaventas = new TVenta[ventas.length()];

			for(int i = 0; i < ventas.length(); i++){
				JSONObject datos = ventas.getJSONObject(i);
				listaventas[i] = new TVenta();
				listaventas[i].setId(datos.getInt("id"));
				listaventas[i].setID_Vendedor(datos.getInt("idVendedor"));
				listaventas[i].setFecha_Compra(datos.getString("fechaCompra"));
				listaventas[i].setPrecio(datos.getDouble("precio"));
			}
		}
		return listaventas;
	}
}
