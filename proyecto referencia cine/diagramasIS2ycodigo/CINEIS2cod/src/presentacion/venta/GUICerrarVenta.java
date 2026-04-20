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
import negocio.venta.TVenta;
import presentacion.controlador.Controlador;

public class GUICerrarVenta extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUICerrarVenta() {
		super("Cerrar Venta");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos necesarios para cerrar la venta: "));
		
		// Region Media
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
		
		seccionMedia.add(new JLabel("ID: "));
		JTextField id = new JTextField(3);
		seccionMedia.add(id);
		
		seccionMedia.add(new JLabel("ID Vendedor: "));
		JTextField idVendedor = new JTextField(3);
		seccionMedia.add(idVendedor);
		
		seccionMedia.add(new JLabel("Fecha (dd/mm/AA): "));
		JTextField fecha = new JTextField(6);
		seccionMedia.add(fecha);
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TVenta venta = new TVenta();	
				try{
					venta.setId(Integer.parseInt(id.getText()));
					venta.setID_Vendedor(Integer.parseInt(idVendedor.getText()));	
				}catch(NumberFormatException ex){}
				
				venta.setFecha_Compra(fecha.getText());

				Controlador.getInstance().accion(EventosVenta.CIERRA_VENTA, venta);
				
				TCarrito.nuevo_carrito();
				
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
