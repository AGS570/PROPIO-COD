package Presentacion.Campo;

import javax.swing.*;
import java.awt.*;

import Negocio.campo.TCampoInterior;
import Negocio.controlador.Controlador;

public class GUICrearCampoInterior extends JFrame {
    private JTextField txtID, txtSuperficie;
    private JCheckBox chkAcondicionado;

    public GUICrearCampoInterior() {
        super("Nuevo Campo Interior");
        initGUI();
    }

    private void initGUI() {
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("ID:"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("Superficie:"));
        txtSuperficie = new JTextField();
        add(txtSuperficie);

        add(new JLabel("¿Acondicionado?"));
        chkAcondicionado = new JCheckBox();
        add(chkAcondicionado);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            TCampoInterior tInt = new TCampoInterior(
                txtID.getText(), 
                false, 
                txtSuperficie.getText(), 
                chkAcondicionado.isSelected()
            );
            Controlador.getInstance().accion(EventosCampo.CREAR_CAMPO, tInt);
            dispose();
        });

        add(btnAceptar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}