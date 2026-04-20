package integracion.sala;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import negocio.sala.TSala;
import negocio.sala.TSalaNormal;
import negocio.sala.TSalaVip;

public class DAOSalaImp implements DAOSala {

	@Override
	public int create(TSala tSala) {
		if (tSala != null) {
			int id = tSala.getId();
			int numero_sala = tSala.getNumero_sala();
			int aforo = tSala.getAforo();

			String tipo;
			int numero_anuncios = -1;
			Boolean adaptada = null;
			if (tSala instanceof TSalaNormal) {
				tipo = "normal";
				numero_anuncios = ((TSalaNormal) tSala).getNum_anuncios();
			} else {
				tipo = "vip";
				adaptada = ((TSalaVip) tSala).getAdaptada();
			}

			if (id != -1 && numero_sala != -1 && aforo != -1 && (numero_anuncios != -1 || adaptada != null)) {
				InputStream archivo;
				try {
					archivo = new FileInputStream("resources/db/db.json");
				} catch (FileNotFoundException ex) {
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray salas = json.getJSONArray("salas");

				JSONObject sala = new JSONObject();
				sala.put("id", id);
				sala.put("numero_sala", numero_sala);
				sala.put("aforo", aforo);
				sala.put("tipo", tipo);

				if (tipo.equals("normal"))
					sala.put("numero_anuncios", numero_anuncios);
				else
					sala.put("adaptada", adaptada);

				salas.put(sala);

				try {
					OutputStream escritura = new FileOutputStream("./resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				} catch (IOException ex) {
					System.err.print("ERROR: fallo de escritura en base de datos");
					return -1;
				}

				return id;
			}
		}
		return -1;
	}

	@Override
	public int update(TSala tSala) {
		if (tSala != null) {
			int id = tSala.getId();
			int numero_sala = tSala.getNumero_sala();
			int aforo = tSala.getAforo();

			String tipo;
			int numero_anuncios = -1;
			Boolean adaptada = null;
			if (tSala instanceof TSalaNormal) {
				tipo = "normal";
				numero_anuncios = ((TSalaNormal) tSala).getNum_anuncios();
			} else {
				tipo = "vip";
				adaptada = ((TSalaVip) tSala).getAdaptada();
			}

			if (id != -1) {
				InputStream archivo;
				try {
					archivo = new FileInputStream("resources/db/db.json");
				} catch (FileNotFoundException ex) {
					System.err.print("ERROR: base de datos no encontrada");
					return -1;
				}
				JSONObject json = new JSONObject(new JSONTokener(archivo));
				JSONArray salas = json.getJSONArray("salas");

				int i = 0;
				boolean encontrado = false;
				while (!encontrado && i < salas.length()) {
					JSONObject sala = salas.getJSONObject(i);
					if (sala.getInt("id") == id && sala.getString("tipo").equals(tipo))
						encontrado = true;
					else
						i++;
				}

				if (encontrado) {
					JSONObject sala = salas.getJSONObject(i);

					if (numero_sala != -1)
						sala.put("numero_sala", numero_sala);

					if (aforo != -1)
						sala.put("aforo", aforo);

					if (tipo.equals("normal") && numero_anuncios != -1)
						sala.put("numero_anuncios", numero_anuncios);

					if (tipo.equals("vip") && adaptada != null)
						sala.put("adaptada", adaptada);

					try {
						OutputStream escritura = new FileOutputStream("resources/db/db.json");
						escritura.write(json.toString().getBytes());
						escritura.close();
					} catch (IOException ex) {
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
		if (id != -1) {
			InputStream archivo;
			try {
				archivo = new FileInputStream("resources/db/db.json");
			} catch (FileNotFoundException ex) {
				System.err.print("ERROR: base de datos no encontrada");
				return false;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray salas = json.getJSONArray("salas");

			int i = 0;
			boolean encontrado = false;
			while (!encontrado && i < salas.length()) {
				JSONObject sala = salas.getJSONObject(i);
				if (sala.getInt("id") == id)
					encontrado = true;
				else
					i++;
			}
			if (encontrado) {
				salas.remove(i);
				try {
					OutputStream escritura = new FileOutputStream("resources/db/db.json");
					escritura.write(json.toString().getBytes());
					escritura.close();
				} catch (IOException ex) {
					System.err.print("ERROR: fallo de borrado en base de datos");
					return false;
				}

				return true;
			}
		}
		return false;
	}

	@Override
	public TSala read(int id) {
		if (id != -1) {
			InputStream archivo;
			try {
				archivo = new FileInputStream("resources/db/db.json");
			} catch (FileNotFoundException ex) {
				System.err.print("ERROR: base de datos no encontrada");
				return null;
			}
			JSONObject json = new JSONObject(new JSONTokener(archivo));
			JSONArray salas = json.getJSONArray("salas");

			int i = 0;
			boolean encontrado = false;
			while (!encontrado && i < salas.length()) {
				JSONObject sala = salas.getJSONObject(i);
				if (sala.getInt("id") == id)
					encontrado = true;
				else
					i++;
			}

			if (encontrado) {
				JSONObject datos = salas.getJSONObject(i);
				if(datos.getString("tipo").equals("normal")){
					TSalaNormal sala = new TSalaNormal();
					sala.setId(datos.getInt("id"));
					sala.setNumero_sala(datos.getInt("numero_sala"));
					sala.setAforo(datos.getInt("aforo"));
					sala.setNum_anuncios(datos.getInt("numero_anuncios"));
					return sala;
				}else{
					TSalaVip sala = new TSalaVip();
					sala.setId(datos.getInt("id"));
					sala.setNumero_sala(datos.getInt("numero_sala"));
					sala.setAforo(datos.getInt("aforo"));
					sala.setAdaptada(datos.getBoolean("adaptada"));
					return sala;
				}
			}
		}
		return null;
	}

	@Override
	public TSala[] readAll() {
		InputStream archivo;
		try {
			archivo = new FileInputStream("resources/db/db.json");
		} catch (FileNotFoundException ex) {
			System.err.print("ERROR: base de datos no encontrada");
			return null;
		}
		JSONObject json = new JSONObject(new JSONTokener(archivo));
		JSONArray salas = json.getJSONArray("salas");

		TSala[] listaSalas = null;

		if (salas.length() > 0) {
			listaSalas = new TSala[salas.length()];

			for (int i = 0; i < salas.length(); i++) {
				JSONObject datos = salas.getJSONObject(i);
				if(datos.getString("tipo").equals("normal")){
					TSalaNormal sala = new TSalaNormal();
					sala.setId(datos.getInt("id"));
					sala.setNumero_sala(datos.getInt("numero_sala"));
					sala.setAforo(datos.getInt("aforo"));
					sala.setNum_anuncios(datos.getInt("numero_anuncios"));
					listaSalas[i] = sala;
				}else{
					TSalaVip sala = new TSalaVip();
					sala.setId(datos.getInt("id"));
					sala.setNumero_sala(datos.getInt("numero_sala"));
					sala.setAforo(datos.getInt("aforo"));
					sala.setAdaptada(datos.getBoolean("adaptada"));
					listaSalas[i] = sala;
				}
			}
		}
		return listaSalas;
	}

}
