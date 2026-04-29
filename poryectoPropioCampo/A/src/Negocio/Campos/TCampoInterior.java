package Negocio.Campos;

public class TCampoInterior extends TCampo {
    private boolean acondicionado;

    public TCampoInterior(String id, boolean ocupado, String tipoSuperficie, boolean acondicionado) {
        super(id, ocupado, tipoSuperficie);
        this.acondicionado = acondicionado;
    }

    public boolean getAcondicionado() { return acondicionado; }
    public void setAcondicionado(boolean acondicionado) { this.acondicionado = acondicionado; }
}