package presentacion.sala;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSala extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelSala(){
		super(new GridLayout(1, 7));
		setBorder(BorderFactory.createTitledBorder("Salas"));
		initGUI();
	}
	
	private void initGUI(){
		JButton crearNorm = new JButton("Crear Normal");
		JButton crearVip = new JButton("Crear VIP");
		JButton actualizarNorm = new JButton("Actualizar Normal");
		JButton actualizarVip = new JButton("Actualizar VIP");
		JButton eliminar = new JButton("Eliminar");
		JButton mostrar = new JButton("Mostrar");
		JButton mostrarTodo = new JButton("Mostrar Todas");
		
		crearNorm.addActionListener(e -> new GUICreaSalaNormal());
		crearVip.addActionListener(e -> new GUICreaSalaVip());
		actualizarNorm.addActionListener(e -> new GUIActualizaSalaNormal());
		actualizarVip.addActionListener(e -> new GUIActualizaSalaVip());
		eliminar.addActionListener(e -> new GUIQuitaSala());
		mostrar.addActionListener(e -> new GUIMostrarSala());
		mostrarTodo.addActionListener(e -> new GUIMostrarSalas());
		
		add(crearNorm);
		add(crearVip);
		add(actualizarNorm);
		add(actualizarVip);
		add(eliminar);
		add(mostrar);
		add(mostrarTodo);
	}
	
}

