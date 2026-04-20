package presentacion.empleado;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;

public class GUIQuitaEmpleado  extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUIQuitaEmpleado(){
		super("Quitar Empleado");
		JPanel quitaemplp= new JPanel();
		quitaemplp.setLayout(new BoxLayout(quitaemplp,BoxLayout.Y_AXIS));
		this.setContentPane(quitaemplp);
		
		JPanel arriba= new JPanel();
		JLabel msgarriba= new JLabel("Introduzca los datos nescesarios: ");
		arriba.add(msgarriba);
		quitaemplp.add(arriba);
		
		JPanel secciondatos= new JPanel();
		quitaemplp.add(secciondatos);
		JLabel msgid= new JLabel("ID: ");
		secciondatos.add(msgid);
		JTextField textid= new JTextField(3);
		secciondatos.add(textid);
		
		JPanel terminar= new JPanel();
		quitaemplp.add(terminar);
		JButton acepta= new JButton("Aceptar");
		JButton cancela= new JButton("Cancelar");
		
		acepta.addActionListener((e)->{
			int idint = -1;
			try{idint = Integer.parseInt(textid.getText());} catch(NumberFormatException ex){}
			
			Controlador.getInstance().accion(EventosEmpleado.QUITA_EMPLEADO, idint);
			
			dispose();
		});
		cancela.addActionListener((e) -> dispose());
		
		terminar.add(acepta);
		terminar.add(cancela);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}