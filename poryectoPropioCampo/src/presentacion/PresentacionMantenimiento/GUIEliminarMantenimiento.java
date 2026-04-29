package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIEliminarMantenimiento extends JFrame implements IGUI {
    
    private static final long serialVersionUID = 1L;

    public GUIEliminarMantenimiento() {
        super("Eliminar Empleado Mantenimiento");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setContentPane(panel);
        
        JPanel seccionAlta = new JPanel();
        panel.add(seccionAlta);
        seccionAlta.add(new JLabel("Introduzca el ID del empleado a eliminar:"));
        JTextField id = new JTextField(8);
        seccionAlta.add(id);
        
        JPanel seccionBaja = new JPanel();
        panel.add(seccionBaja);
        
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");
        seccionBaja.add(aceptar);
        seccionBaja.add(cancelar);

        this.pack();
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!id.getText().isEmpty()) {
                    try {
                        int idMantenimiento = Integer.parseInt(id.getText());
                        // Controlador.getInstance().accion(EventosMantenimiento.ELIMINAR_MANTENIMIENTO, idMantenimiento);
                        dispose();
                    } catch(NumberFormatException w) { 
                        JOptionPane.showMessageDialog(GUIEliminarMantenimiento.this, "El ID no es válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(GUIEliminarMantenimiento.this, "Faltan campos por rellenar");
                }
            }
        });  
        
        cancelar.addActionListener(e -> dispose());
    }

    @Override
    public void actualizar(int evento, Object datos) {
    }
}