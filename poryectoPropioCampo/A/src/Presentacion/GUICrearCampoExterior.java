package Presentacion;

import javax.swing.*;
import java.awt.*;
import Negocio.Controlador;
import Negocio.TCampoExterior;

public class GUICrearCampoExterior extends JFrame {
    private JTextField txtID, txtSuperficie, txtClima;

    public GUICrearCampoExterior() {
        super("Nuevo Campo Exterior");
        initGUI();
    }

    private void initGUI() {
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("ID:"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("Superficie:"));
        txtSuperficie = new JTextField();
        add(txtSuperficie);

        add(new JLabel("Clima:"));
        txtClima = new JTextField();
        add(txtClima);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            String id = txtID.getText();
            String superficie = txtSuperficie.getText();
            String clima = txtClima.getText();

            // Creamos el Transfer Object
            TCampoExterior tExt = new TCampoExterior(id, false, superficie, clima);
            
            // Enviamos al controlador
            Controlador.getInstance().accion(EventosCampo.CREAR_CAMPO, tExt);
            dispose();
        });

        add(btnAceptar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}