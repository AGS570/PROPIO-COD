package presentacion.Campo;

import java.awt.event.ActionListener;

import javax.swing.*;

import Negocio.Campo.TCampoExterior;
import presentacion.Eventos;
import presentacion.PresentacionControlador.Controlador;

import java.awt.*;


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

          
            TCampoExterior tExt = new TCampoExterior(id, false, superficie, clima);
            
         
            Controlador.getInstance().accion(Eventos.CREAR_CAMPO, tExt);
            dispose();
        });

        add(btnAceptar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}