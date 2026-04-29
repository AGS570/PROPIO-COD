package Negocio.NegocioMantenimiento;

import Negocio.*;
public class TMantenimiento extends TEmpleado {

    private String tipoMantenimiento;

    // Constructor completo
    public TMantenimiento(int id, String dni, String nombre, String tlf, double salario, String tipoMantenimiento) {
    	super(id, dni, nombre, tlf, salario);
        this.tipoMantenimiento = tipoMantenimiento;
	}

    public TMantenimiento(String dni, String nombre, String tlf, double salario, String tipoMantenimiento) {
        super(dni, nombre, tlf, salario);
        this.tipoMantenimiento = tipoMantenimiento;
    }
    
	// Getters y Setters definidos en el diagrama
    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }
}