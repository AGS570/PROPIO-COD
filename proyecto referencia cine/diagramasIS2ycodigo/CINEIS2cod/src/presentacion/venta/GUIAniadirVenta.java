package presentacion.venta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.venta.TCarrito;
import negocio.venta.TLineaVenta;

public class GUIAniadirVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public GUIAniadirVenta(){
		super("Añadir Venta");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos necesarios para añadir una nueva venta: "));
		
		// Region Media
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
				
		seccionMedia.add(new JLabel("ID Proyeccion: "));
		JTextField idProy = new JTextField(3);
		seccionMedia.add(idProy);
				
		seccionMedia.add(new JLabel("Numero entradas: "));
		JTextField entradas = new JTextField(3);
		seccionMedia.add(entradas);

		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TLineaVenta linea = new TLineaVenta();
				try{
					linea.setIdProyeccion(Integer.parseInt(idProy.getText()));
					linea.setCantidadEntradas(Integer.parseInt(entradas.getText()));
				}catch(NumberFormatException ex){}

				TCarrito.aniadirLineaVenta(linea);
				
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
