package integracion.sala;

import negocio.sala.TSala;

public interface DAOSala {
	public int create(TSala tSala);
	public int update(TSala tSala);
	public boolean delete(int id);
	public TSala read(int id);
	public TSala[] readAll();
}
