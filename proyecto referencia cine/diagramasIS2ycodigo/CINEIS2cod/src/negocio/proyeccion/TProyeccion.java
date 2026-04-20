package negocio.proyeccion;

public class TProyeccion {
	
	private int id;
	private int numEntradas;
	private String nombreInterno;
	private String fecha;
	private int hora;
	private int id_sala;
	private int id_pelicula;
	private double precio;
	
	//constructor
	public TProyeccion(){
		id = hora = id_sala = id_pelicula = -1;
		nombreInterno = fecha = null;
		precio = -1;
		numEntradas = 0;
	}
	
	//getters
	public int getID(){
		return id;
	}
	
	public int getNumEntradas(){
		return numEntradas;
	}
	
	public int getHora(){
		return hora;
	}
	
	public String getNombreInterno(){
		return nombreInterno;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public int getId_sala(){
		return id_sala;
	}
	
	public int getId_pelicula(){
		return id_pelicula;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	//setters
	public int setID(int id){
		return this.id = id;
	}
	
	public int setNumEntradas(int numEntradas){
		return this.numEntradas = numEntradas;
	}
	
	public int setHora(int hora){
		return this.hora = hora;
	}
	
	public String setNombreInterno(String nombreInterno){
		return this.nombreInterno = nombreInterno;
	}
	
	public String setFecha(String fecha){
		return this.fecha = fecha;
	}
	
	public int setId_sala(int id_sala){
		return this.id_sala = id_sala;
	}
	
	public int setId_pelicula(int id_pelicula){
		return this.id_pelicula = id_pelicula;
	}
	
	public double setPrecio(double precio){
		return this.precio = precio;
	}
	
}