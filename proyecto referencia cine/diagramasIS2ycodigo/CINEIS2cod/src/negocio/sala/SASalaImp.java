package negocio.sala;

import integracion.FactoriaIntegracion;
import integracion.proyeccion.DAOProyeccion;
import integracion.sala.DAOSala;
import negocio.proyeccion.TProyeccion;

public class SASalaImp implements SASala {

    @Override
    public int create(TSala tSala) {
        if(tSala != null){
            DAOSala dao = FactoriaIntegracion.getInstance().hacerDAOSala();
            if(tSala.getId() != -1){
                TSala buscada = dao.read(tSala.getId());
                if(buscada == null){
                    return dao.create(tSala);
                }
            }
        }
        return -1;
    }

    @Override
    public int update(TSala tSala) {
        if(tSala != null)
            return FactoriaIntegracion.getInstance().hacerDAOSala().update(tSala);
        return -1;
    }

    @Override
    public boolean delete(int id) {
        if(id != -1){
            FactoriaIntegracion factoria = FactoriaIntegracion.getInstance();
            
            DAOProyeccion daoProyeccion = factoria.hacerDAOProyeccion();
			TProyeccion[] proyecciones = daoProyeccion.readAllBySala(id);
			for(int i = 0; i < proyecciones.length; i++)
				daoProyeccion.delete(proyecciones[i].getID());
			
            return factoria.hacerDAOSala().delete(id);
        }
        return false;
    }

    @Override
    public TSala read(int id) {
        if(id != -1)
            return FactoriaIntegracion.getInstance().hacerDAOSala().read(id);
        return null;
    }

    @Override
    public TSala[] readAll() {
        return FactoriaIntegracion.getInstance().hacerDAOSala().readAll();
    }

}