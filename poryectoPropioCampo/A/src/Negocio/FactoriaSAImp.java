package Negocio;
public class FactoriaSAImp extends FactoriaSA {
    @Override
    public SACampo getSACampo() {
        return new SACampoImp();
    }
}