package presentacion.PresentacionJugador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Negocio.NegocioJugador.TJugador;
import presentacion.Eventos;
import presentacion.IGUI;
import presentacion.PresentacionControlador.Controlador;

public class GUICrearJugador extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUICrearJugador() {
	
		super("Crear Jugador");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos para crear un jugador:"));
		
		// Region Media
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
		
		seccionMedia.add(new JLabel("Nombre: "));
		JTextField nombre = new JTextField(6);
		seccionMedia.add(nombre);
		
		seccionMedia.add(new JLabel("Telefono: "));
		JTextField tlf = new JTextField(10);
		seccionMedia.add(tlf);
		
		seccionMedia.add(new JLabel("Pie Dominante: "));
		JComboBox<String> pie = new JComboBox<>(new String[]{"Derecho", "Izquierdo"});
		seccionMedia.add(pie);
		
		seccionMedia.add(new JLabel("Posicion: "));
		JTextField posicion = new JTextField(10);
		seccionMedia.add(posicion);
		
		seccionMedia.add(new JLabel("dni: "));
		JTextField dni = new JTextField(5);
		seccionMedia.add(dni);
		
		
		// Region Baja
		JPanel seccionBaja = new JPanel();
		panel.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		seccionBaja.add(aceptar);
		seccionBaja.add(cancelar);

		//pack lo ajusta automaticamente sin poner un setsize
		//setSize(new Dimension(500,500));
		this.pack();
		
		
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//todos los campos son obligatorios en crear
		        if(nombre.getText().isEmpty() || dni.getText().isEmpty() ||
		          posicion.getText().isEmpty() ||
		           tlf.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(GUICrearJugador.this,
		                "Todos los campos son obligatorios",
		                "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        TJugador tj = new TJugador(dni.getText(),nombre.getText(),tlf.getText(),posicion.getText(), pie.getSelectedItem().toString()); 
					
				Controlador.getInstance().accion(Eventos.CREAR_JUGADOR, tj);
				dispose();
			}	
			
		}
		
		cancelar.addActionListener(e->dispose());
	}

	@Override
	public void actualizar(int evento, Object datos) {}
	
	
	//el main es solo para hacer pruebas
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUICrearJugador();
            }
        });
    }

}
