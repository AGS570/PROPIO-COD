package presentacion.proyeccion;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelProyeccion extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public PanelProyeccion(){
		super(new GridLayout(1,5));
		setBorder(BorderFactory.createTitledBorder("Proyecciones"));
		initGUI();
	}

	private void initGUI() {
		JButton crear = new JButton("Crear");
		JButton actualizar = new JButton("Actualizar");
		JButton eliminar = new JButton("Eliminar");
		JButton mostrar = new JButton("Mostrar");
		JButton mostrarTodo = new JButton("Mostrar Todas");
		
		crear.addActionListener(e -> new GUICreaProyeccion());
		actualizar.addActionListener(e -> new GUIActualizaProyeccion());
		eliminar.addActionListener(e -> new GUIQuitaProyeccion());
		mostrar.addActionListener(e -> new GUIMostrarProyeccion());
		mostrarTodo.addActionListener(e -> new GUIMostrarProyecciones());
		
		add(crear);
		add(actualizar);
		add(eliminar);
		add(mostrar);
		add(mostrarTodo);
	}

}