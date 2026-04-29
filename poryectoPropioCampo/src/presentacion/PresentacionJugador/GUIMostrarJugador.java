package presentacion.PresentacionJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import presentacion.Eventos;
import presentacion.IGUI;
import presentacion.PresentacionControlador.Controlador;

public class GUIMostrarJugador extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIMostrarJugador() {
	
		super("Mostrar Jugador");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca el id del jugador para mostrar sus datos:"));
		JTextField id = new JTextField(8);
		seccionAlta.add(id);
		
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
		
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//para que aparezca en medio
		this.setLocationRelativeTo(null);
		
		
		aceptar.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(id.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(GUIMostrarJugador.this, 
			                "Faltan campos por rellenar");
			            return;
			        }

			        int idJugador;
			        try {
			            idJugador = Integer.parseInt(id.getText());
			        } catch(NumberFormatException w) {
			            JOptionPane.showMessageDialog(GUIMostrarJugador.this,
			                "El ID no es valido", "Error de formato", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        Controlador.getInstance().accion(Eventos.MOSTRAR_JUGADOR, idJugador);
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
                new GUIMostrarJugador();
            }
        });
    }
}