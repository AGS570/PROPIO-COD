package Integracion.IntegracionJugador;

import java.util.Collection;

import Negocio.NegocioJugador.TJugador;

public interface DAOJugador {
	public abstract int create(TJugador tj);
	public abstract TJugador read(int id);
	public abstract Collection<TJugador> readAll();
	public abstract TJugador readByDni(String dni);
	//public abstract Collection<TEquipo> readEquiposDelJugador(int id);//igual es mejor usar collection<T> en vez de array
	public abstract int update(TJugador tj);
	public abstract int delete(int id);
}
