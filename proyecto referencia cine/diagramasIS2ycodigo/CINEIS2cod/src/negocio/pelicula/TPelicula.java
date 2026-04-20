package negocio.pelicula;

public class TPelicula {
	
	private int id;
	private String nombre;
	private int duracion;
	private String clasificacion;
	
	public TPelicula(){
		id = duracion = -1;
		nombre = clasificacion = null;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getDuracion(){
		return duracion;
	}
	
	public String getClasificacion(){
		return clasificacion;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setDuracion(int duracion){
		this.duracion = duracion;
	}
	
	public void setClasificacion(String clasificacion){
		this.clasificacion = clasificacion;
	}
	
}
