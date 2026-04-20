
package presentacion.venta;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;

public class GUIMuestraVentas extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public GUIMuestraVentas() {
		super("Mostrar Ventas");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("¿Desea mostrar todas las ventas existentes?"));
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(e -> {Controlador.getInstance().accion(EventosVenta.MUESTRA_VENTAS, null); dispose();});
		
		cancelar.addActionListener(e -> dispose());
		
		seccionBaja.add(aceptar);
		seccionBaja.add(cancelar);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}