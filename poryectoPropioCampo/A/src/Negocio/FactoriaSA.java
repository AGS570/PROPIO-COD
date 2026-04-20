package Negocio;

public abstract class FactoriaSA {
    private static FactoriaSA instance;

    public static FactoriaSA getInstance() {
        if (instance == null) {
            instance = new FactoriaSAImp();
        }
        return instance;
    }

    public abstract SACampo getSACampo();
}


