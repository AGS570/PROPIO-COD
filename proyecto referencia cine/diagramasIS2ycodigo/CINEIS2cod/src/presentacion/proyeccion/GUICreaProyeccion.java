package presentacion.proyeccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.proyeccion.TProyeccion;
import presentacion.controlador.Controlador;

public class GUICreaProyeccion extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUICreaProyeccion(){
		super("Crear Proyeccion");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		//Region alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos necesarios para crear una nueva proyeccion: "));
		
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
		
		seccionMedia.add(new JLabel("ID: "));
		JTextField id = new JTextField(2);
		seccionMedia.add(id);
		
		seccionMedia.add(new JLabel("Nombre interno: "));
		JTextField nombreInterno = new JTextField(6);
		seccionMedia.add(nombreInterno);
		
		seccionMedia.add(new JLabel("Fecha: "));
		JTextField fecha = new JTextField(4);
		seccionMedia.add(fecha);
		
		seccionMedia.add(new JLabel("Hora: "));
		JTextField hora = new JTextField(3);
		seccionMedia.add(hora);
		
		seccionMedia.add(new JLabel("Id Sala: "));
		JTextField id_sala = new JTextField(2);
		seccionMedia.add(id_sala);
		
		seccionMedia.add(new JLabel("Id Pelicula: "));
		JTextField id_pelicula = new JTextField(2);
		seccionMedia.add(id_pelicula);
		
		seccionMedia.add(new JLabel("Precio: "));
		JTextField precio = new JTextField(4);
		seccionMedia.add(precio);
		
		//Region baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TProyeccion datos = new TProyeccion();
				try{
					datos.setID(Integer.parseInt(id.getText()));
					datos.setHora(Integer.parseInt(hora.getText()));
					datos.setId_sala(Integer.parseInt(id_sala.getText()));
					datos.setId_pelicula(Integer.parseInt(id_pelicula.getText()));
					datos.setPrecio(Double.parseDouble(precio.getText()));
				}catch(NumberFormatException ex){}
				
				datos.setFecha(fecha.getText());
				datos.setNombreInterno(nombreInterno.getText());
				
				Controlador.getInstance().accion(EventosProyeccion.CREA_PROYECCION, datos);
				
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