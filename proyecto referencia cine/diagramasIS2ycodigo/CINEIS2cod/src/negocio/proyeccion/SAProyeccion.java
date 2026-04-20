package negocio.proyeccion;

public interface SAProyeccion {
	public int create(TProyeccion tProyeccion);
	public TProyeccion read(int id);
	public TProyeccion[] readAll();
	public TProyeccion[] readAllBySala(int id_pelicula);
	public TProyeccion[] readAllByPelicula(int id_sala);
	public int update (TProyeccion tProyeccion);
	public boolean delete(int id);
}