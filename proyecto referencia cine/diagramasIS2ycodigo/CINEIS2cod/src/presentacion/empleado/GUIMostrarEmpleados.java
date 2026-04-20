package presentacion.empleado;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.controlador.Controlador;

public class GUIMostrarEmpleados  extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUIMostrarEmpleados(){
		super("Mostrar Empleados");
		JPanel mostraremplp= new JPanel();
		mostraremplp.setLayout(new BoxLayout(mostraremplp,BoxLayout.Y_AXIS));
		this.setContentPane(mostraremplp);
		
		JPanel seccionAlta = new JPanel();
		mostraremplp.add(seccionAlta);
		seccionAlta.add(new JLabel("¿Desea mostrar todos los empleados existentes?"));
		
		JPanel seccionBaja = new JPanel();
		mostraremplp.add(seccionBaja);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		aceptar.addActionListener(e -> {
			Controlador.getInstance().accion(EventosEmpleado.MUESTRA_EMPLEADOS, null); 
			dispose();
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