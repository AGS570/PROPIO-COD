package Negocio.campo;

public class TCampoExterior extends TCampo {
    private String clima;

    public TCampoExterior(String id, boolean ocupado, String tipoSuperficie, String clima) {
        super(id, ocupado, tipoSuperficie);
        this.clima = clima;
    }

    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }
}