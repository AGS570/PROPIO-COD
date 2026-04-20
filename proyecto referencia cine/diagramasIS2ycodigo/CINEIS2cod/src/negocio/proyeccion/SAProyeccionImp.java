package negocio.proyeccion;

import integracion.FactoriaIntegracion;
import integracion.pelicula.DAOPelicula;
import integracion.proyeccion.DAOProyeccion;
import integracion.sala.DAOSala;

public class SAProyeccionImp implements SAProyeccion{

	@Override
	public int create(TProyeccion tProyeccion) {
		if(tProyeccion != null){
			DAOProyeccion daoProy = FactoriaIntegracion.getInstance().hacerDAOProyeccion();
			if(tProyeccion.getID() != -1 && daoProy.read(tProyeccion.getID()) == null && tProyeccion.getId_pelicula() != -1 && tProyeccion.getId_sala() != -1){	
				DAOPelicula daoPeli = FactoriaIntegracion.getInstance().hacerDAOPelicula();
				DAOSala daoSala = FactoriaIntegracion.getInstance().hacerDAOSala();
				if(daoPeli.read(tProyeccion.getId_pelicula()) != null && daoSala.read(tProyeccion.getId_sala()) != null)
					return daoProy.create(tProyeccion);
				}
			}
		return -1;
	}

	@Override
	public TProyeccion read(int id) {
		if(id != -1)
			return FactoriaIntegracion.getInstance().hacerDAOProyeccion().read(id);
		return null;
	}

	@Override
	public TProyeccion[] readAll() {
		return FactoriaIntegracion.getInstance().hacerDAOProyeccion().readAll();
	}

	@Override
	public TProyeccion[] readAllBySala(int id_sala) {
		if(id_sala != -1)
			return FactoriaIntegracion.getInstance().hacerDAOProyeccion().readAllBySala(id_sala);
		return null;
	}

	@Override
	public TProyeccion[] readAllByPelicula(int id_pelicula) {
		if(id_pelicula != -1)
			return FactoriaIntegracion.getInstance().hacerDAOProyeccion().readAllByPelicula(id_pelicula);
		return null;
	}

	@Override
	public int update(TProyeccion tProyeccion) {
		if(tProyeccion != null)
			return FactoriaIntegracion.getInstance().hacerDAOProyeccion().update(tProyeccion);
		return -1;
	}

	@Override
	public boolean delete(int id) {
		if(id != -1)
			return FactoriaIntegracion.getInstance().hacerDAOProyeccion().delete(id);
		return false;
	}	

}
