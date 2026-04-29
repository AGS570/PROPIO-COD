package Integracion.IntegracionJugador;

import java.util.Collection;

import Negocio.NegocioJugador.TJugador;

public class DAOJugadorImp implements DAOJugador{

	@Override
	public int create(TJugador tj) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public TJugador read(int id) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Collection<TJugador> readAll() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public TJugador readByDni(String dni) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public int update(TJugador tj) {
		// TODO Apéndice de método generado automáticamente
//		En el DAO, compruebas qué campos tiene rellenos el transfer, solo el id es obligatorio
//		pq actualizas los campos que quieras
//		if(tj.getNombre() != null) // actualizar nombre
//			if(tj.getDni() != null)    // actualizar dni
//			// ...
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

}
