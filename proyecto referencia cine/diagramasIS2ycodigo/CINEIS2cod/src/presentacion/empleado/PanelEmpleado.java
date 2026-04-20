package presentacion.empleado;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelEmpleado extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelEmpleado(){
		super(new GridLayout(1, 5));
		setBorder(BorderFactory.createTitledBorder("Empleados"));
		initGUI();
	}
	
	private void initGUI(){
		JButton crear = new JButton("Crear");
		JButton actualizar = new JButton("Actualizar");
		JButton eliminar = new JButton("Eliminar");
		JButton mostrar = new JButton("Mostrar");
		JButton mostrarTodo = new JButton("Mostrar Todos");
		
		crear.addActionListener(e -> new GUICreaEmpleado());
		actualizar.addActionListener(e -> new GUIActualizaEmpleado());
		eliminar.addActionListener(e -> new GUIQuitaEmpleado());
		mostrar.addActionListener(e -> new GUIMostrarEmpleado());
		mostrarTodo.addActionListener(e -> new GUIMostrarEmpleados());
		
		add(crear);
		add(actualizar);
		add(eliminar);
		add(mostrar);
		add(mostrarTodo);
	}
}

