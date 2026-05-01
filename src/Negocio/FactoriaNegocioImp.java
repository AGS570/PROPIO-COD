package Negocio;

import Negocio.NegocioJugador.SA_Jugador;
import Negocio.NegocioJugador.SA_JugadorImp;

public class FactoriaNegocioImp extends FactoriaNegocio{

	@Override
	public SA_Jugador hacerSAJugador() {
		return new SA_JugadorImp();
	}

	@Override
	public SA_Equipo hacerSAEquipo() {
		return new SA_EquipoImp();
	}

	@Override
	public SA_Entrenador hacerSAEntrenador() {
		return new SA_EntrenadorImp();
	}

	@Override
	public SA_Partido hacerSAPartido() {
		return new SA_PartidoImp();
	}

	@Override
	public SA_Campo hacerSACampo() {
		return new SA_CampoImp();
	}

	@Override
	public SA_Mantenimiento hacerSAMantenimiento() {
		return new SA_MantenimientoImp();
	}

}
