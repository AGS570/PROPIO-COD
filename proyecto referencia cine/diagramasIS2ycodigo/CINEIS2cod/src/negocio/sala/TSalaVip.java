package negocio.sala;

public class TSalaVip extends TSala {

	private Boolean adaptada;

    public TSalaVip(){
        super();
        adaptada = null;
    }

    public Boolean getAdaptada() {
        return adaptada;
    }

    public void setAdaptada(boolean adaptada) {
        this.adaptada = adaptada;
    }

}
