package Presentacion.Campo;

import javax.swing.*;
import java.awt.*;

import Negocio.campo.TCampoInterior;
import Negocio.controlador.Controlador;

public class GUIActualizarCampoInterior extends JFrame {
    private JTextField txtID, txtSuperficie;
    private JCheckBox chkAcondicionado;

    public GUIActualizarCampoInterior(TCampoInterior t) {
        super("Actualizar Campo Interior");
        setLayout(new GridLayout(4, 2));
        
        txtID = new JTextField(t.getID()); txtID.setEditable(false);
        txtSuperficie = new JTextField(t.getTipoSuperficie());
        chkAcondicionado = new JCheckBox("Acondicionado", t.getAcondicionado());

        add(new JLabel("ID:")); add(txtID);
        add(new JLabel("Superficie:")); add(txtSuperficie);
        add(new JLabel("Aire:")); add(chkAcondicionado);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> {
            TCampoInterior nuevo = new TCampoInterior(txtID.getText(), false, txtSuperficie.getText(), chkAcondicionado.isSelected());
            Controlador.getInstance().accion(EventosCampo.ACTUALIZAR_CAMPO, nuevo);
            dispose();
        });
        add(btnActualizar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}