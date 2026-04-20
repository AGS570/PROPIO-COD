package launcher;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.empleado.PanelEmpleado;
import presentacion.pelicula.PanelPelicula;
import presentacion.proyeccion.PanelProyeccion;
import presentacion.sala.PanelSala;
import presentacion.venta.PanelVenta;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("Aplicación de gestión Cinenova");
		initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		JLabel logo = new JLabel(new ImageIcon("resources/icons/logo.png"));
		logo.setBorder(new EmptyBorder(15, 15, 15, 15));
		this.add(logo, BorderLayout.NORTH);
		
		JPanel capabilities = new JPanel();
		capabilities.setLayout(new BoxLayout(capabilities, BoxLayout.Y_AXIS));
		mainPanel.add(capabilities, BorderLayout.CENTER);

		capabilities.add(new PanelPelicula());
		capabilities.add(Box.createVerticalStrut(15));
		capabilities.add(new PanelSala());
		capabilities.add(Box.createVerticalStrut(15));
		capabilities.add(new PanelProyeccion());
		capabilities.add(Box.createVerticalStrut(15));
		capabilities.add(new PanelEmpleado());
		capabilities.add(Box.createVerticalStrut(15));
		capabilities.add(new PanelVenta());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}