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



public class GUIActualizarJugador extends JFrame implements IGUI{

	
	private static final long serialVersionUID = 1L;

	public GUIActualizarJugador() {
	
		super("Actualizar Jugador");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca los datos preferidos para actualizar un jugador existente:"));
		
		// Region Media
		JPanel seccionMedia = new JPanel();
		panel.add(seccionMedia);
		
		seccionMedia.add(new JLabel("Nombre: "));
		JTextField nombre = new JTextField(6);
		seccionMedia.add(nombre);
		
		seccionMedia.add(new JLabel("Telefono: "));
		JTextField tlf = new JTextField(10);
		seccionMedia.add(tlf);
		
		seccionMedia.add(new JLabel("ID: "));
		JTextField id = new JTextField(5);
		seccionMedia.add(id);
		
		seccionMedia.add(new JLabel("Pie Dominante: "));
		JComboBox<String> pie = new JComboBox<>(new String[]{"", "Derecho", "Izquierdo"});
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
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//cambiar pq para modificar el id es basicamente el vincular/desvincular
//				try {
//					tj.setIdEquipo(Integer.parseInt(idEquipo.getText()));
//				}catch(NumberFormatException w) {}
				
				 //El ID es obligatorio para saber qué jugador actualizar, los demas campos no tienen que serlo pq actualizas 
				//lo que quieres
		        if(id.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(GUIActualizarJugador.this, 
		                "El ID es obligatorio", 
		                "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        
		        TJugador tj = new TJugador();
		        try {
		            tj.setId(Integer.parseInt(id.getText()));
		        } catch(NumberFormatException w) {
		            JOptionPane.showMessageDialog(GUIActualizarJugador.this, 
		                "El ID debe ser un número válido", 
		                "Error de formato", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		     // Opcionales, solo se setean si el usuario los rellena
		        if(!nombre.getText().isEmpty()) tj.setNombre(nombre.getText());
		        if(!dni.getText().isEmpty()) tj.setDni(dni.getText());
		        if(!tlf.getText().isEmpty()) tj.setTelefono(tlf.getText());
		        if(!pie.getSelectedItem().toString().isEmpty()) tj.setPie(pie.getSelectedItem().toString());
		        if(!posicion.getText().isEmpty()) tj.setPosicion(posicion.getText());
				
			
				Controlador.getInstance().accion(Eventos.ACTUALIZAR_JUGADOR, tj);
				dispose();
			}
			
		});  
		
		cancelar.addActionListener(e->dispose());
	}
	
	
	@Override
	public void actualizar(int evento, Object datos) {}
	
	public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new GUIActualizarJugador();
	            }
	        });
	    }

	
}
