package presentacion.proyeccion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.controlador.Controlador;

public class GUIMostrarProyecciones extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUIMostrarProyecciones(){
		super("Mostrar Proyecciones");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("¿Desea mostrar todas las proyecciones existentes?"));
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);

		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(e -> {
			Controlador.getInstance().accion(EventosProyeccion.MUESTRA_PROYECCIONES, null);
			dispose();
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

