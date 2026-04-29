package Negocio.NegocioJugador;

import java.util.Collection;

public interface SA_Jugador {
	public abstract int create(TJugador tj);
	public abstract TJugador read(int id);
	public abstract Collection<TJugador> readAll();
	public abstract Collection<TJugador> readJugadoresDelEquipo(int idEquipo);
	public abstract int update(TJugador tj);
	public abstract int delete(int id);
	
}
