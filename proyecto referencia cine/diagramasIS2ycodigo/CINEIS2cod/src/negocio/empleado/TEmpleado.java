package negocio.empleado;

public class TEmpleado {
	
	private int id;
	private int nif;
	private String nombre;
	private int salario;
	private int numTaquilla;
	
	public TEmpleado(){
		id = -1;
		nif = -1;
		salario= -1;
		numTaquilla = -1;
		nombre = null;
	}
	
	public int getId(){
		return id;
	}
	
	public int getnif(){
		return nif;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getSalario(){
		return salario;
	}
	
	public int getnumTaquilla(){
		return numTaquilla;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int setnif(int nif){
		return this.nif=nif;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setSalario(int Salario){
		this.salario = Salario;
	}
	
	public void setnumTaquilla(int numTaquilla){
		this.numTaquilla = numTaquilla;
	}
	
}