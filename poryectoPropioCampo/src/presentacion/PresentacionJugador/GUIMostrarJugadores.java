package presentacion.PresentacionJugador;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import presentacion.IGUI;

public class GUIMostrarJugadores extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIMostrarJugadores() {
	
		super("Mostrar todos los jugadores");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("¿Desea mostrar todos los jugadores existentes?"));
		
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
		
		
		aceptar.addActionListener(e->{
			//Controlador.getInstance().accion(EventosJugador.MOSTRAR_JUGADORES, null);
			this.dispose();
		});
		
		cancelar.addActionListener(e->dispose());
	}

	@Override
	public void actualizar(int evento, Object datos) {}
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIMostrarJugadores();
            }
        });
    }
}