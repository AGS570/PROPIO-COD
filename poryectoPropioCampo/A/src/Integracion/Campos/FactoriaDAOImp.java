package Integracion.Campos;

class FactoriaDAOImp extends FactoriaDAO {
 @Override
 public DAOCampo getDAOCampo() {
     return new DAOCampoImp();
 }
}