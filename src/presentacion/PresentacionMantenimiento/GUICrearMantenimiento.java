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
import Negocio.NegocioMantenimiento.TMantenimiento;

public class GUICrearMantenimiento extends JFrame implements IGUI {
    
    private static final long serialVersionUID = 1L;

    public GUICrearMantenimiento() {
        super("Crear Empleado de Mantenimiento");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setContentPane(panel);
        
        // Región Alta
        JPanel seccionAlta = new JPanel();
        panel.add(seccionAlta);
        seccionAlta.add(new JLabel("Introduzca los datos para crear un empleado de mantenimiento:"));
        
        // Región Media
        JPanel seccionMedia = new JPanel();
        panel.add(seccionMedia);
        
        seccionMedia.add(new JLabel("Nombre: "));
        JTextField nombre = new JTextField(10);
        seccionMedia.add(nombre);
        
        seccionMedia.add(new JLabel("DNI: "));
        JTextField dni = new JTextField(9);
        seccionMedia.add(dni);
        
        seccionMedia.add(new JLabel("Teléfono: "));
        JTextField tlf = new JTextField(9);
        seccionMedia.add(tlf);

        seccionMedia.add(new JLabel("Salario: "));
        JTextField salario = new JTextField(6);
        seccionMedia.add(salario);
        
        seccionMedia.add(new JLabel("Tipo Mantenimiento: "));
        JTextField tipo = new JTextField(10);
        seccionMedia.add(tipo);
        
        // Región Baja
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
                try {
                    // Validaciones básicas de campos vacíos
                    if(nombre.getText().isEmpty() || dni.getText().isEmpty() || tipo.getText().isEmpty() || tlf.getText().isEmpty() || salario.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(GUICrearMantenimiento.this, "Faltan campos por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    TMantenimiento tm = new TMantenimiento(
                        0, // ID autogenerado
                        dni.getText(),
                        nombre.getText(),
                        Integer.parseInt(tlf.getText()),
                        Double.parseDouble(salario.getText()),
                        tipo.getText()
                    );
                    
                    // Descomentar cuando tengas el Controlador y Eventos listos
                    // Controlador.getInstance().accion(EventosMantenimiento.CREAR_MANTENIMIENTO, tm);
                    dispose();

                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GUICrearMantenimiento.this, "El teléfono y salario deben ser numéricos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });  
        
        cancelar.addActionListener(e -> dispose());
    }

    @Override
    public void actualizar(int evento, Object datos) {
        // Lógica de respuesta a los eventos de éxito o fallo
    }
}