package Negocio;

public class TPersona {

    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private boolean activo;

    public TPersona(String dni, String nombre, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        
        this.activo = true; //no estoy seguro
    }

    public TPersona() {
    	this.activo = true; //no estoy seguro
    }

	public TPersona(int id, String dni, String nombre, String tlf) {
		this.id = id;
		this.dni = dni;
        this.nombre = nombre;
        this.telefono = tlf;
        this.activo = true; //no estoy seguro
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public boolean getActivo() {
		return activo;
	}
    
    public void setActivo(boolean estado) {
		activo = estado;
	}
}