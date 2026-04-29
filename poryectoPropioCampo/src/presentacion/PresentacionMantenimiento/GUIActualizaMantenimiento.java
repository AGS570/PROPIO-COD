package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Negocio.NegocioMantenimiento.TMantenimiento;

public class GUIActualizarMantenimiento extends JFrame implements IGUI {
    public GUIActualizarMantenimiento() {
        super("Actualizar Mantenimiento");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setContentPane(panel);

        JTextField id = new JTextField(5);
        JTextField nombre = new JTextField(10);
        JTextField tlf = new JTextField(10);
        JTextField salario = new JTextField(10);
        JTextField tipo = new JTextField(10);

        panel.add(new JLabel("ID del empleado a modificar:")); panel.add(id);
        panel.add(new JLabel("Nuevo Nombre:")); panel.add(nombre);
        panel.add(new JLabel("Nuevo Teléfono:")); panel.add(tlf);
        panel.add(new JLabel("Nuevo Salario:")); panel.add(salario);
        panel.add(new JLabel("Nuevo Tipo:")); panel.add(tipo);

        JButton aceptar = new JButton("Actualizar");
        panel.add(aceptar);

        aceptar.addActionListener(e -> {
            try {
                TMantenimiento tm = new TMantenimiento(
                    Integer.parseInt(id.getText()),
                    "", // El DNI no se suele cambiar en un update
                    nombre.getText(),
                    Integer.parseInt(tlf.getText()),
                    Double.parseDouble(salario.getText()),
                    tipo.getText()
                );
                Controlador.getInstance().accion(EventosMantenimiento.ACTUALIZAR_MANTENIMIENTO, tm);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos");
            }
        });
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actualizar(int evento, Object datos) {
        if (evento == EventosMantenimiento.ACTUALIZAR_MANTENIMIENTO_OK) {
            JOptionPane.showMessageDialog(this, "Mantenimiento actualizado");
        }
    }
}