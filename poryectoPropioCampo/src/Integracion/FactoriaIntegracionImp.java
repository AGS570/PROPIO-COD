package Integracion;

import Integracion.Campo.DAOCampo;
import Integracion.Campo.DAOCampoImp;
import Integracion.IntegracionJugador.DAOJugador;
import Integracion.IntegracionJugador.DAOJugadorImp;
import Integracion.IntegracionMantenimiento.DAOMantenimiento;
import Integracion.IntegracionMantenimiento.DAOMantenimientoImp;



public class FactoriaIntegracionImp extends FactoriaIntegracion{

	@Override
	public DAOJugador hacerDAOJugador() {
		return new DAOJugadorImp();
	}

	@Override
	public DAOEquipo hacerDAOEquipo() {
		return new DAOEquipoImp();
	}

	@Override
	public DAOPartido hacerDAOPartido() {
		return new DAOPartidoImp();
	}

	@Override
	public DAOCampo hacerDAOCampo() {
		return new DAOCampoImp();
	}

	@Override
	public DAOEntrenador hacerDAOEntrenador() {
		return new DAOEntrenadorImp();
	}

	@Override
	public DAOMantenimiento hacerDAOMantenimiento() {
		return new DAOMantenimientoImp();
	}

}
