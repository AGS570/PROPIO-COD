package presentacion.venta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;

public class GUIMuestraVenta extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public GUIMuestraVenta() {
		super("Mostrar Venta");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca el ID de la venta a buscar: "));
		JTextField id = new JTextField(2);
		seccionAlta.add(id);
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int dato = -1;
				try{dato = Integer.parseInt(id.getText());} catch(NumberFormatException ex){}
				
				Controlador.getInstance().accion(EventosVenta.MUESTRA_VENTA, dato);
				
				dispose();
			}
		});
		
		cancelar.addActionListener(e -> dispose());
		
		seccionBaja.add(aceptar);
		seccionBaja.add(cancelar);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}
