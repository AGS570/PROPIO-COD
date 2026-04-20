package integracion.pelicula;

import negocio.pelicula.TPelicula;

public interface DAOPelicula {
	public int create(TPelicula tPelicula);
	public int update(TPelicula tPelicula);
	public boolean delete(int id);
	public TPelicula read(int id);
	public TPelicula[] readAll();
}
