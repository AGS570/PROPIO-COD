package presentacion.empleado;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;

public class GUIMostrarEmpleado  extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUIMostrarEmpleado(){
		super("Mostrar Empleado");
		JPanel mostraremplp= new JPanel();
		mostraremplp.setLayout(new BoxLayout(mostraremplp,BoxLayout.Y_AXIS));
		this.setContentPane(mostraremplp);
		
		JPanel arriba= new JPanel();
		mostraremplp.add(arriba);
		JLabel msgarriba= new JLabel("Introduce el ID del empleado que quieres mostrar: ");
		arriba.add(msgarriba);
		
		JPanel datospanel= new JPanel();
		JLabel msgid= new JLabel("ID: ");
		datospanel.add(msgid);
		JTextField textid= new JTextField(3);
		datospanel.add(textid);
		mostraremplp.add(datospanel);
		
		JPanel terminar= new JPanel();
		mostraremplp.add(terminar);
		JButton acepta= new JButton("Aceptar");
		JButton cancela= new JButton("Cancelar");

		acepta.addActionListener((e)->{
			int dato =-1;
			try{dato = Integer.parseInt(textid.getText());} catch(NumberFormatException err){}

			Controlador.getInstance().accion(EventosEmpleado.MUESTRA_EMPLEADO, dato);
			
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