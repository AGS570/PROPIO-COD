package presentacion.Campo;


import javax.swing.*;
import java.awt.*;
import Negocio.Campo.TCampoInterior;

import presentacion.PresentacionControlador.Controlador;
import presentacion.Eventos;

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
            Controlador.getInstance().accion(Eventos.ACTUALIZAR_CAMPO, nuevo);
            dispose();
        });
        add(btnActualizar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}