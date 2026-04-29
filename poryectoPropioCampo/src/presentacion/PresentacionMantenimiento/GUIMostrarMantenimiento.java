package presentacion.PresentacionMantenimiento;

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

import Negocio.NegocioMantenimiento.TMantenimiento;
import presentacion.IGUI;
import presentacion.PresentacionControlador.Controlador;
import presentacion.Mantenimiento.EventosMantenimiento;

public class GUIMostrarMantenimiento extends JFrame implements IGUI {
    
    private static final long serialVersionUID = 1L;

    public GUIMostrarMantenimiento() {
    
       super("Mostrar Empleado Mantenimiento");
       JPanel panel = new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       this.setContentPane(panel);
       
       // Region Alta
       JPanel seccionAlta = new JPanel();
       panel.add(seccionAlta);
       seccionAlta.add(new JLabel("Introduzca el id del empleado para mostrar sus datos:"));
       JTextField id = new JTextField(8);
       seccionAlta.add(id);
       
       // Region Baja
       JPanel seccionBaja = new JPanel();
       panel.add(seccionBaja);
       
       JButton aceptar = new JButton("Aceptar");
       JButton cancelar = new JButton("Cancelar");
       seccionBaja.add(aceptar);
       seccionBaja.add(cancelar);

       this.pack();
       
       this.setVisible(true);
       this.setResizable(true);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       // Para que aparezca en el centro
       this.setLocationRelativeTo(null);
       
       aceptar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(id.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(GUIMostrarMantenimiento.this, 
                      "Faltan campos por rellenar");
                  return;
              }

              int idMantenimiento;
              try {
                  idMantenimiento = Integer.parseInt(id.getText());
              } catch(NumberFormatException w) {
                  JOptionPane.showMessageDialog(GUIMostrarMantenimiento.this,
                      "El ID no es válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
                  return;
              }

              Controlador.getInstance().accion(EventosMantenimiento.MOSTRAR_MANTENIMIENTO, idMantenimiento);
              dispose();
          }
       });  
       
       // Lambda eliminada, usando clase anónima
       cancelar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
           }
       });
    }

    @Override
    public void actualizar(int evento, Object datos) {
        // Aquí es donde se procesa la respuesta del controlador y se muestran los datos reales
        if (evento == EventosMantenimiento.MOSTRAR_MANTENIMIENTO_OK) {
            TMantenimiento tm = (TMantenimiento) datos;
            
            // Construimos un String con los datos del trabajador devuelto por la Base de Datos
            String info = "ID: " + tm.getId() + "\n" +
                          "DNI: " + tm.getDNI() + "\n" +
                          "Nombre: " + tm.getNombre() + "\n" +
                          "Teléfono: " + tm.getTlf() + "\n" +
                          "Salario: " + tm.getSalario() + "\n" +
                          "Tipo: " + tm.getTipoMantenimiento();
                          
            JOptionPane.showMessageDialog(this, info, "Datos del Empleado", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (evento == EventosMantenimiento.MOSTRAR_MANTENIMIENTO_KO) {
            JOptionPane.showMessageDialog(this, "No se ha encontrado ningún empleado con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIMostrarMantenimiento();
            }
        });
    }
}