package Negocio.NegocioJugador;

import Negocio.TPersona;

public class TJugador extends TPersona{
	private String posicion;
	private String pieDominante;
	private int idEquipo;

	public TJugador(int id, String dni, String nombre, String telefono,
            String posicion, String pieDominante, int idEquipo) {
		super(id, dni, nombre, telefono);
		this.posicion = posicion;
		this.pieDominante = pieDominante;
		this.idEquipo = idEquipo;
	}
	
	public TJugador(String dni, String nombre, String telefono, String pos, String pieDominante) {
		super(dni, nombre, telefono);
		this.posicion = pos;
		this.pieDominante = pieDominante;
	}
	
	public TJugador() {
		super();
	}

	public String getPosicion() {
		return posicion;
	}
	
	public String getPieDominante() {
		return pieDominante;
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void setPie(String pie) {
		this.pieDominante = pie;
	}
	
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	


}
