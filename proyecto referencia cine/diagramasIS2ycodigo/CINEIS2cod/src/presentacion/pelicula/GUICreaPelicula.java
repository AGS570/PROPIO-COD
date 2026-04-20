package presentacion.pelicula;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.pelicula.TPelicula;
import presentacion.controlador.Controlador;

public class GUICreaPelicula extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUICreaPelicula(){
		super("Crear Pelicula");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos necesarios para crear una nueva pelicula:"));
		
		// Region Media
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
		
		seccionMedia.add(new JLabel("ID: "));
		JTextField id = new JTextField(2);
		seccionMedia.add(id);
		
		seccionMedia.add(new JLabel("Nombre: "));
		JTextField nombre = new JTextField(6);
		seccionMedia.add(nombre);
		
		seccionMedia.add(new JLabel("Duración (min.): "));
		JTextField duracion = new JTextField(3);
		seccionMedia.add(duracion);
		
		seccionMedia.add(new JLabel("Clasificación: "));
		JTextField clasificacion = new JTextField(6);
		seccionMedia.add(clasificacion);
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TPelicula datos = new TPelicula();			
				try{
					datos.setId(Integer.parseInt(id.getText()));
					datos.setDuracion(Integer.parseInt(duracion.getText()));
				}catch(NumberFormatException ex){}
				
				datos.setNombre(nombre.getText());
				datos.setClasificacion(clasificacion.getText());
				
				Controlador.getInstance().accion(EventosPelicula.CREA_PELICULA, datos);
				
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
