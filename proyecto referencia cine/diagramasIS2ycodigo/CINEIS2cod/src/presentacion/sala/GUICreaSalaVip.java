package presentacion.sala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.sala.TSalaVip;
import presentacion.controlador.Controlador;

public class GUICreaSalaVip extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public GUICreaSalaVip(){
		super("Crea Sala Vip");
		JPanel panel= new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		
		//Region Superior
		JPanel seccionsuperior= new JPanel();
		panel.add(seccionsuperior);
		seccionsuperior.add(new JLabel("Introduzca los datos necesarios para crear una nueva sala vip: "));
		
		//Region Media
		JPanel seccionmedia= new JPanel();
		panel.add(seccionmedia);
		
		seccionmedia.add(new JLabel("ID: "));
		JTextField id= new JTextField(2);
		seccionmedia.add(id);
		
		seccionmedia.add(new JLabel("Aforo: "));
		JTextField aforo= new JTextField(3);
		seccionmedia.add(aforo);
		
		seccionmedia.add(new JLabel("Numero de Sala: "));
		JTextField numero= new JTextField(2);
		seccionmedia.add(numero);
		
		seccionmedia.add(new JLabel("Adaptada: "));
		JComboBox<Boolean> adaptada = new JComboBox<Boolean>(new Boolean[]{true, false});
		seccionmedia.add(adaptada);
		
		//Region inferior
		JPanel seccionInferior= new JPanel();
		panel.add(seccionInferior);
		
		JButton aceptar= new JButton("Aceptar");
		JButton cancelar= new JButton("Cancelar");
		
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TSalaVip datos= new TSalaVip();
				try{
					datos.setId(Integer.parseInt(id.getText()));
					datos.setNumero_sala(Integer.parseInt(numero.getText()));
					datos.setAforo(Integer.parseInt(aforo.getText()));
				}catch(NumberFormatException ex){}
				
				datos.setAdaptada((boolean) adaptada.getSelectedItem());
				
				Controlador.getInstance().accion(EventosSala.CREA_SALA, datos);
				
				dispose();
			}	
		});
			
		cancelar.addActionListener(e -> dispose());
		
		seccionInferior.add(aceptar);
		seccionInferior.add(cancelar);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
