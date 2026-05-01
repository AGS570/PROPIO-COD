package Negocio;

public class TEmpleado extends TPersona {

    private double salario;

    public TEmpleado(int id, String dni, String nombre, String tlf, double salario) {
    	super(id, dni, nombre, tlf);
        this.salario = salario;
	}
    
    //constructor sin id
    public TEmpleado(String dni, String nombre, String telefono, double salario) {
        super(dni, nombre, telefono);
        this.salario = salario;
    }
    
	public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}