package negocio.empleado;

import integracion.FactoriaIntegracion;
import integracion.empleado.DAOEmpleado;

public class SAEmpleadoImp implements SAEmpleado{

	@Override
	public int create(TEmpleado TEmpleado) {
		if(TEmpleado != null && TEmpleado.getId() != -1){
			DAOEmpleado demp = FactoriaIntegracion.getInstance().hacerDAOEmpleado();
			TEmpleado temp = demp.read(TEmpleado.getId());
			if(temp == null){
				return demp.create(TEmpleado);
			}
		}
		
		return -1;
	}

	@Override
	public int update(TEmpleado TEmpleado) {
		if(TEmpleado != null)
			return FactoriaIntegracion.getInstance().hacerDAOEmpleado().update(TEmpleado);
		return -1;
	}
	
	@Override
	public boolean delete(int id) {
		if(id != -1){
			return FactoriaIntegracion.getInstance().hacerDAOEmpleado().delete(id);
		}
		return false;
	}

	@Override
	public TEmpleado read(int id) {
		if(id!=-1) return FactoriaIntegracion.getInstance().hacerDAOEmpleado().read(id);
		return null;
	}

	@Override
	public TEmpleado[] readAll() {
		return FactoriaIntegracion.getInstance().hacerDAOEmpleado().readAll();
	}

}
