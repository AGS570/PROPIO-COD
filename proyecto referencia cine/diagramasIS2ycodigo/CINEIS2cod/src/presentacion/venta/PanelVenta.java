package presentacion.venta;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelVenta extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelVenta(){
		super(new GridLayout(1, 8));
		setBorder(BorderFactory.createTitledBorder("Ventas"));
		initGUI();
	}
	
	private void initGUI(){
		JButton abrir = new JButton("Abrir");
		JButton aniadir = new JButton("Añadir");
		JButton eliminar = new JButton("Eliminar");
		JButton cerrar = new JButton("Cerrar");
		JButton devolver = new JButton("Devolver");
		JButton mostrar = new JButton("Mostrar Venta");
		JButton mostrarTodas = new JButton("Mostrar Ventas");
		JButton mostrarLV = new JButton("Mostrar Lineas de Venta");
		
		abrir.addActionListener(e -> new GUIAbrirVenta());
		aniadir.addActionListener(e -> new GUIAniadirVenta());
		eliminar.addActionListener(e -> new GUIEliminarVenta());
		cerrar.addActionListener(e -> new GUICerrarVenta());
		devolver.addActionListener(e -> new GUIDevolverVenta());
		mostrar.addActionListener(e -> new GUIMuestraVenta());
		mostrarTodas.addActionListener(e -> new GUIMuestraVentas());
		mostrarLV.addActionListener(e -> new GUIMuestraLineasVenta());
		
		add(abrir);
		add(aniadir);
		add(eliminar);
		add(cerrar);
		add(devolver);
		add(mostrar);
		add(mostrarTodas);
		add(mostrarLV);
	}
}
