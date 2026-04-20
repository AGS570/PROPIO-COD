package integracion.empleado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import negocio.empleado.TEmpleado;

public class DAOEmpleadoImp implements DAOEmpleado{

	@Override
	public int create(TEmpleado TEmpleado) {
		
		if(TEmpleado != null){
			int id = TEmpleado.getId();
			int nif=TEmpleado.getnif();
			String nombre= TEmpleado.getNombre();
			int salario = TEmpleado.getSalario();
			int numTaquilla=TEmpleado.getnumTaquilla();
			if(id != -1 && nif!=-1 && nombre != null && salario != -1 && numTaquilla != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray empleados = json.getJSONArray("empleados");
				
				JSONObject empleado = new JSONObject();
				empleado.put("id", id);
				empleado.put("nif",nif);
				empleado.put("nombre", nombre);
				empleado.put("salario", salario);
				empleado.put("numero_taquilla", numTaquilla);
				
				empleados.put(empleado);

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

	@Override
	public int update(TEmpleado TEmpleado) {
		if(TEmpleado != null){
			int id = TEmpleado.getId();
			int nif= TEmpleado.getnif();
			String nombre= TEmpleado.getNombre();
			int salario = TEmpleado.getSalario();
			int numTaquilla = TEmpleado.getnumTaquilla();
			if(id != -1){
				InputStream archivo;
				try{
					archivo = new FileInputStream("resources/db/db.json");
				}catch(FileNotFoundException ex){
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray empleados = json.getJSONArray("empleados");
				
				int i = 0;
				boolean encontrado = false; 
				while(!encontrado && i < empleados.length()){
					JSONObject empleado = empleados.getJSONObject(i);
					if(empleado.getInt("id") == id)
						encontrado = true;
					else i++;
				}

				if(encontrado){
					JSONObject empleado = empleados.getJSONObject(i);
					
					if(nif != -1)
						empleado.put("nif", nif);
					
					if(nombre != null)
						empleado.put("nombre", nombre);
					
					if(salario != -1)
						empleado.put("salario", salario);
					
					if(numTaquilla != -1)
						empleado.put("numero_taquilla", numTaquilla);

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

	@Override
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
			JSONArray empleados = json.getJSONArray("empleados");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < empleados.length()){
				JSONObject empleado = empleados.getJSONObject(i);
				if(empleado.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				empleados.remove(i);

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

	@Override
	public TEmpleado read(int id) {
		if(id != -1){
			InputStream archivo;
			try{
				archivo = new FileInputStream("resources/db/db.json");
			}catch(FileNotFoundException ex){
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray empleados = json.getJSONArray("empleados");
			
			int i = 0;
			boolean encontrado = false; 
			while(!encontrado && i < empleados.length()){
				JSONObject empleado = empleados.getJSONObject(i);
				if(empleado.getInt("id") == id)
					encontrado = true;
				else i++;
			}
			
			if(encontrado){
				JSONObject atrib = empleados.getJSONObject(i);
				TEmpleado empleado = new TEmpleado();
				empleado.setId(atrib.getInt("id"));
				empleado.setnif(atrib.getInt("nif"));
				empleado.setNombre(atrib.getString("nombre"));
				empleado.setSalario(atrib.getInt("salario"));
				empleado.setnumTaquilla(atrib.getInt("numero_taquilla"));
			
				return empleado;
			}
		}
		return null;
	}

	@Override
	public TEmpleado[] readAll() {
		InputStream archivo;
		try{
			archivo = new FileInputStream("resources/db/db.json");
		}catch(FileNotFoundException ex){
			System.err.print("ERROR: base de datos no encontrada");
			return null;
		}
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray empleados = json.getJSONArray("empleados");
		
		TEmpleado[] lEmpleados =null;
		
		if(empleados.length() > 0){
			lEmpleados = new TEmpleado[empleados.length()];

			for(int i = 0; i < empleados.length(); i++){
				JSONObject atrib = empleados.getJSONObject(i);
				lEmpleados[i] = new TEmpleado();
				lEmpleados[i].setId(atrib.getInt("id"));
				lEmpleados[i].setnif(atrib.getInt("nif"));
				lEmpleados[i].setNombre(atrib.getString("nombre"));
				lEmpleados[i].setSalario(atrib.getInt("salario"));
				lEmpleados[i].setnumTaquilla(atrib.getInt("numero_taquilla"));
			}
		}
		return lEmpleados;
	}

}
