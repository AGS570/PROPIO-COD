package presentacion.pelicula;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPelicula extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public PanelPelicula(){
		super(new GridLayout(1, 5));
		setBorder(BorderFactory.createTitledBorder("Peliculas"));
		initGUI();
	}
	
	private void initGUI(){
		JButton crear = new JButton("Crear");
		JButton actualizar = new JButton("Actualizar");
		JButton eliminar = new JButton("Eliminar");
		JButton mostrar = new JButton("Mostrar");
		JButton mostrarTodo = new JButton("Mostrar Todas");
		
		crear.addActionListener(e -> new GUICreaPelicula());
		actualizar.addActionListener(e -> new GUIActualizaPelicula());
		eliminar.addActionListener(e -> new GUIQuitaPelicula());
		mostrar.addActionListener(e -> new GUIMostrarPelicula());
		mostrarTodo.addActionListener(e -> new GUIMostrarPeliculas());
		
		add(crear);
		add(actualizar);
		add(eliminar);
		add(mostrar);
		add(mostrarTodo);
	}
	
}
