package presentacion.venta;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import negocio.venta.TCarrito;

public class GUIAbrirVenta extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUIAbrirVenta() {
		super("Abrir Venta");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("¿Desea abrir una nueva venta? (Se borrará el anterior carrito si no ha sido procesado)"));
		
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton abrir = new JButton("Abrir");
		JButton cancelar = new JButton("Cancelar");
		
		abrir.addActionListener(e-> {TCarrito.nuevo_carrito(); dispose();});
		cancelar.addActionListener(e -> dispose());
		
		seccionBaja.add(abrir);
		seccionBaja.add(cancelar);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}