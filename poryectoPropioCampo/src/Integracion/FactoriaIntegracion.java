package Integracion;


import Integracion.FactoriaIntegracionImp;
import Integracion.IntegracionJugador.DAOJugador;
import Integracion.IntegracionMantenimiento.DAOMantenimiento;



public abstract class FactoriaIntegracion {
		
	private static FactoriaIntegracion instancia;
	
	public static FactoriaIntegracion getInstance(){
		if(instancia == null)
			instancia = new FactoriaIntegracionImp();
		return instancia;
	}
	
	public abstract DAOJugador hacerDAOJugador();
	public abstract DAOEquipo hacerDAOEquipo();
	public abstract DAOPartido hacerDAOPartido();
	public abstract DAOCampo hacerDAOCampo();
	public abstract DAOEntrenador hacerDAOEntrenador();
	public abstract DAOMantenimiento hacerDAOMantenimiento();
	
		
}
