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


public class GUIEliminarJugador extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIEliminarJugador() {
	
		super("Eliminar Jugador");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		// Region Alta
		JPanel seccionAlta = new JPanel();
		panel.add(seccionAlta);
		seccionAlta.add(new JLabel("Introduzca el id del jugador a eliminar:"));
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
				int idJugador;
				if(!id.getText().isEmpty()) {
					try {
					    idJugador = Integer.parseInt(id.getText());
					}catch(NumberFormatException w) { JOptionPane.showMessageDialog(GUIEliminarJugador.this,
							"El ID no es valido", "Error de formato", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}else {
					JOptionPane.showMessageDialog(GUIEliminarJugador.this, "El id es obligatorio");
					return;
				}
		
				Controlador.getInstance().accion(Eventos.ELIMINAR_JUGADOR, idJugador);
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
                new GUIEliminarJugador();
            }
        });
    }
}

