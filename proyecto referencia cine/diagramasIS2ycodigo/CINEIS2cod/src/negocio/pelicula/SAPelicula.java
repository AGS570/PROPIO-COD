package negocio.pelicula;

public interface SAPelicula {
	public int create(TPelicula tPelicula);
	public int update(TPelicula tPelicula);
	public boolean delete(int id);
	public TPelicula read(int id);
	public TPelicula[] readAll();
}
