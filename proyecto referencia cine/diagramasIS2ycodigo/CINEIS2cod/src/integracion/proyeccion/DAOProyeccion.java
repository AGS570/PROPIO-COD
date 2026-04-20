package integracion.proyeccion;

import negocio.proyeccion.TProyeccion;

public interface DAOProyeccion  {
	public int create(TProyeccion tProyeccion);
	public TProyeccion read(int id);
	public TProyeccion[] readAll();
	public TProyeccion[] readAllBySala(int id_sala);
	public TProyeccion[] readAllByPelicula(int id_pelicula);
	public int update (TProyeccion tProyeccion);
	public boolean delete(int id);
}
