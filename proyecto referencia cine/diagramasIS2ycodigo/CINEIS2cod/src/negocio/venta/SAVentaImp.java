package negocio.venta;

import integracion.FactoriaIntegracion;
import integracion.FactoriaIntegracionImp;
import integracion.empleado.DAOEmpleado;
import integracion.proyeccion.DAOProyeccion;
import integracion.venta.DAOLineasVenta;
import integracion.venta.DAOVenta;
import negocio.proyeccion.TProyeccion;
import negocio.sala.TSala;
import negocio.venta.TVenta;

public class SAVentaImp implements SAVenta {

	public int create(TVenta tVenta) {
		if (tVenta != null) {
			DAOVenta dao = FactoriaIntegracionImp.getInstance().hacerDAOVenta();
			if (tVenta.getId() != -1 && dao.read(tVenta.getId()) == null) {
				DAOEmpleado daoEmp = FactoriaIntegracionImp.getInstance().hacerDAOEmpleado();
				if (tVenta.getID_Vendedor() != -1 && daoEmp.read(tVenta.getID_Vendedor()) != null) {
					int cantidadCarrito = TCarrito.getCantidad();
					TLineaVenta[] lineasVenta = TCarrito.getLineasVenta().toArray(new TLineaVenta[cantidadCarrito]);

					DAOProyeccion daoProy = FactoriaIntegracionImp.getInstance().hacerDAOProyeccion();

					double precio = 0;

					for (int i = 0; i < cantidadCarrito; i++) {
						TProyeccion proy = daoProy.read(lineasVenta[i].getIdProyeccion());
						if (proy != null) {
							TSala sala = FactoriaIntegracionImp.getInstance().hacerDAOSala().read(proy.getId_sala());
							if (sala != null && (lineasVenta[i].getCantidadEntradas() + proy.getNumEntradas() <= sala.getAforo())) {
								lineasVenta[i].setIdVenta(tVenta.getId());
								precio += (proy.getPrecio() * (double)lineasVenta[i].getCantidadEntradas());

								proy.setNumEntradas(proy.getNumEntradas() + lineasVenta[i].getCantidadEntradas());
								daoProy.update(proy);

								FactoriaIntegracionImp.getInstance().hacerDAOLineasVenta().create(lineasVenta[i]);
							}else{
								tVenta.setPrecio(precio);
								dao.create(tVenta);
								return -1;
							}
						}else{
							tVenta.setPrecio(precio);
							dao.create(tVenta);
							return -1;
						}
					}
					
					tVenta.setPrecio(precio);
					return dao.create(tVenta);
				}
			}
		}
		return -1;
	}

	public boolean devolver(int id) {
		if (id != -1) {
			DAOVenta dao = FactoriaIntegracionImp.getInstance().hacerDAOVenta();
			if (dao.read(id) != null) {
				DAOLineasVenta daolv = FactoriaIntegracionImp.getInstance().hacerDAOLineasVenta();
				TLineaVenta[] lineasVenta = daolv.readAllByID(id);
				
				if(lineasVenta != null){
					for (int i = 0; i < lineasVenta.length; i++) {
						DAOProyeccion daoProy = FactoriaIntegracionImp.getInstance().hacerDAOProyeccion();
						TProyeccion proy = daoProy.read(lineasVenta[i].getIdProyeccion());
						if(proy != null){
							proy.setNumEntradas(proy.getNumEntradas() - lineasVenta[i].getCantidadEntradas());
							daoProy.update(proy);
						}
					}
				}
				
				daolv.deleteAllById(id);
				dao.delete(id);
				return true;
			}
		}
		return false;
	}

	public TVenta read(int id) {
		if(id != -1)
			return FactoriaIntegracion.getInstance().hacerDAOVenta().read(id);
		return null;
	}

	public TVenta[] readAll() {
		return FactoriaIntegracion.getInstance().hacerDAOVenta().readAll();
	}

	public TLineaVenta[] readLineasVenta(int id) {
		if(id != -1)
			return FactoriaIntegracion.getInstance().hacerDAOLineasVenta().readAllByID(id);
		return null;
	}
}
