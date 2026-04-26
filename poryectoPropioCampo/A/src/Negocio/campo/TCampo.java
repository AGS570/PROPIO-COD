package Negocio.campo;

public class TCampo {
    private String ID;
    private boolean ocupado;
    private String tipoSuperficie;

    public TCampo(String id, boolean ocupado, String tipoSuperficie) {
        this.ID = id;
        this.ocupado = ocupado;
        this.tipoSuperficie = tipoSuperficie;
    }

    public String getID() { return ID; }
    public void setID(String id) { this.ID = id; }
    
    public boolean getOcupado() { return ocupado; }
    public void setOcupado(boolean ocupado) { this.ocupado = ocupado; }
    
    public String getTipoSuperficie() { return tipoSuperficie; }
    public void setTipoSuperficie(String tipoSuperficie) { this.tipoSuperficie = tipoSuperficie; }
}