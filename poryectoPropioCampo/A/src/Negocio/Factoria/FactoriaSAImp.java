package Negocio.Factoria;

import Negocio.campo.SACampo;
import Negocio.campo.SACampoImp;

public class FactoriaSAImp extends FactoriaSA {
    @Override
    public SACampo getSACampo() {
        return new SACampoImp();
    }
}