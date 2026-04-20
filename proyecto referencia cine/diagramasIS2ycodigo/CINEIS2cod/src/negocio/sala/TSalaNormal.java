package negocio.sala;

public class TSalaNormal extends TSala {

    private int num_anuncios;

    public TSalaNormal(){
    	super();
    	num_anuncios = -1;
    }

    public int getNum_anuncios() {
        return num_anuncios;
    }

    public void setNum_anuncios(int num_anuncios) {
        this.num_anuncios = num_anuncios;
    }

}