package negocio.pelicula;

import integracion.FactoriaIntegracion;
import integracion.pelicula.DAOPelicula;
import integracion.proyeccion.DAOProyeccion;
import negocio.proyeccion.TProyeccion;

public class SAPeliculaImp implements SAPelicula {

	public int create(TPelicula tPelicula) {
		if(tPelicula != null){
			DAOPelicula dao = FactoriaIntegracion.getInstance().hacerDAOPelicula();
			if(tPelicula.getId() != -1){
				TPelicula buscada = dao.read(tPelicula.getId());
				if(buscada == null){
					return dao.create(tPelicula);
				}
			}
		}
		return -1;
	}

	public int update(TPelicula tPelicula) {
		if(tPelicula != null)
			return FactoriaIntegracion.getInstance().hacerDAOPelicula().update(tPelicula);
		return -1;
	}

	public boolean delete(int id) {
		if(id != -1){
			FactoriaIntegracion factoria = FactoriaIntegracion.getInstance();
			
			DAOProyeccion daoProyeccion = factoria.hacerDAOProyeccion();
			TProyeccion[] proyecciones = daoProyeccion.readAllByPelicula(id);
			for(int i = 0; i < proyecciones.length; i++)
				daoProyeccion.delete(proyecciones[i].getID());
			
			return factoria.hacerDAOPelicula().delete(id);
		}
		return false;
	}

	public TPelicula read(int id) {
		if(id != -1)
			return FactoriaIntegracion.getInstance().hacerDAOPelicula().read(id);
		return null;
	}

	public TPelicula[] readAll() {
		return FactoriaIntegracion.getInstance().hacerDAOPelicula().readAll();
	}

}
