package Negocio.NegocioJugador;

import java.util.Collection;


import Integracion.FactoriaIntegracion;
import Integracion.IntegracionJugador.DAOJugador;


public class SA_JugadorImp implements SA_Jugador{

	@Override
	public int create(TJugador tj) {
		int id = -1;
		DAOJugador dj = FactoriaIntegracion.getInstance().hacerDAOJugador();
		if(tj != null) {
			TJugador tjLeido = dj.readByDni(tj.getDni());
			if(tjLeido == null) id = dj.create(tj);
		}
		return id;
	}

	@Override
	public TJugador read(int id) {
		if(id > 0) {
			 return FactoriaIntegracion.getInstance().hacerDAOJugador().read(id);
		}
		return null;
	}

	@Override
	public Collection<TJugador> readAll() {
		return FactoriaIntegracion.getInstance().hacerDAOJugador().readAll();
	}

	@Override
	public Collection<TJugador> readJugadoresDelEquipo(int idEquipo) {
		if(idEquipo > 0) {
			//return FactoriaIntegracion.getInstance().hacerDAOJugador().readJugadoresDelEquipo(idEquipo);
		}
		return null;
	}

	@Override
	public int update(TJugador tj) {
		if(tj != null && tj.getId() > 0)//no hay ids negativos 
			return FactoriaIntegracion.getInstance().hacerDAOJugador().update(tj);
		return -1;
	}

	//TODO la baja del jugador es logica y solo se puede eliminar si no esta vinculado a ningun equipo
	@Override
	public int delete(int id) {
		int res = -1;
		DAOJugador dj = FactoriaIntegracion.getInstance().hacerDAOJugador();
		if(id > 0) {//en caso de que el usuario haya introducido un id negativo
			//ver si existe jugador con dicho id
			TJugador tjLeido = dj.read(id);
			if(tjLeido != null && tjLeido.getActivo()) {
				if(tjLeido.getIdEquipo() == -1) {
					res = dj.delete(id);
					//otra forma seria pasarle al update el transfer modificado, pero entonces el delete del
					//dao se queda inutil
					//tjLeido.setActivo(false);
					//res = dj.update(tjLeido);
				}
			}
		}
		return res;
	}
	

}
