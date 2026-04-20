package Presentacion;

import javax.swing.*;
import java.awt.*;
import Negocio.Controlador;
import Negocio.TCampoExterior;

public class GUIActualizarCampoExterior extends JFrame {
    private JTextField txtID, txtSuperficie, txtClima;

    public GUIActualizarCampoExterior(TCampoExterior t) {
        super("Actualizar Campo Exterior");
        setLayout(new GridLayout(4, 2));
        
        txtID = new JTextField(t.getID()); txtID.setEditable(false);
        txtSuperficie = new JTextField(t.getTipoSuperficie());
        txtClima = new JTextField(t.getClima());

        add(new JLabel("ID:")); add(txtID);
        add(new JLabel("Superficie:")); add(txtSuperficie);
        add(new JLabel("Clima:")); add(txtClima);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> {
            TCampoExterior nuevo = new TCampoExterior(txtID.getText(), false, txtSuperficie.getText(), txtClima.getText());
            Controlador.getInstance().accion(EventosCampo.ACTUALIZAR_CAMPO, nuevo);
            dispose();
        });
        add(btnActualizar);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}