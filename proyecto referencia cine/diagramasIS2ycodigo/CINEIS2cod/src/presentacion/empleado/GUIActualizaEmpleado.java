package presentacion.empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.empleado.TEmpleado;
import presentacion.controlador.Controlador;

public class GUIActualizaEmpleado  extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int[] taquillas={100,101,102,103};

	public GUIActualizaEmpleado(){
		super("Actualizar Empleado");
		JPanel actemplp = new JPanel();
		actemplp.setLayout(new BoxLayout(actemplp,BoxLayout.Y_AXIS));
		this.setContentPane(actemplp);
		
		JPanel arriba= new JPanel();
		JLabel msgarriba = new JLabel("Introduzca los datos del empleado que quiera cambiar: ");
		arriba.add(msgarriba);
		actemplp.add(arriba);
		
		JPanel secciondatos= new JPanel();
		actemplp.add(secciondatos);
		JLabel msgid= new JLabel("ID: ");
		secciondatos.add(msgid);
		JTextField textid = new JTextField(2);
		secciondatos.add(textid);
		
		JLabel msgnif= new JLabel("NIF: ");
		secciondatos.add(msgnif);
		JTextField textnif = new JTextField(6);
		secciondatos.add(textnif);
		
		JLabel msgnombre= new JLabel("Nombre: ");
		secciondatos.add(msgnombre);
		JTextField textnombre = new JTextField(6);
		secciondatos.add(textnombre);
		
		JLabel msgsalario= new JLabel("Salario: ");
		secciondatos.add(msgsalario);
		JTextField textsalario = new JTextField(4);
		secciondatos.add(textsalario);
		
		JLabel msgnumtaquilla= new JLabel("Numero de Taquilla (100-103): ");
		secciondatos.add(msgnumtaquilla);
		JTextField textnumtaquilla = new JTextField(3);
		secciondatos.add(textnumtaquilla);
		
		JPanel terminar= new JPanel();
		actemplp.add(terminar);
		
		JButton acepta= new JButton("Aceptar");
		JButton cancela= new JButton("Cancelar");
		
		acepta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TEmpleado datos = new TEmpleado();			
				try{if(existeTaquilla(Integer.parseInt(textnumtaquilla.getText())))datos.setId(Integer.parseInt(textid.getText()));} catch(NumberFormatException ex){}
				try{datos.setnif(Integer.parseInt(textnif.getText()));} catch(NumberFormatException ex){}
				try{datos.setSalario(Integer.parseInt(textsalario.getText()));} catch(NumberFormatException ex){}
				try{datos.setnumTaquilla(Integer.parseInt(textnumtaquilla.getText()));} catch(NumberFormatException ex){}
				
				if(!textnombre.getText().isEmpty())
					datos.setNombre(textnombre.getText());
				
				Controlador.getInstance().accion(EventosEmpleado.ACTUALIZA_EMPLEADO, datos);
				
				dispose();
			}
		});
		
		cancela.addActionListener((e)-> dispose());
		
		terminar.add(acepta);
		terminar.add(cancela);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private boolean existeTaquilla(int t){
		for(int a: taquillas){
			if(t==a){
				return true;
			}
		}
		return false;
	}
}