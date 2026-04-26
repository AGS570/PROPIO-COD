package Presentacion.Campo;

import javax.swing.*;

import Negocio.controlador.Controlador;

import java.awt.*;

public class GUIEliminarCampo extends JFrame {

    public GUIEliminarCampo() {
        super("Eliminar Campo");
        initGUI();
    }

    private void initGUI() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtID = new JTextField(10);
        JButton btnEliminar = new JButton("Eliminar");

        btnEliminar.addActionListener(e -> {
            String id = txtID.getText();
            if (!id.isEmpty()) {
                Controlador.getInstance().accion(EventosCampo.ELIMINAR_CAMPO, id);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Introduce un ID válido");
            }
        });

        p.add(new JLabel("ID del Campo:"));
        p.add(txtID);
        p.add(btnEliminar);

        this.add(p);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}