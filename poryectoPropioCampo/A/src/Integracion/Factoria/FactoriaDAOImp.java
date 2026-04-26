package Integracion.Factoria;

import Integracion.campo.DAOCampo;
import Integracion.campo.DAOCampoImp;

class FactoriaDAOImp extends FactoriaDAO {
 @Override
 public DAOCampo getDAOCampo() {
     return new DAOCampoImp();
 }
}