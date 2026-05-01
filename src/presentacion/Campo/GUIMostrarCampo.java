package presentacion.Campo;

import javax.swing.JFrame;

import Negocio.Campo.TCampo;
import Negocio.Campo.TCampoExterior;
import Negocio.Campo.TCampoInterior;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIMostrarCampo extends JFrame {

    public GUIMostrarCampo(TCampo t) {
        super("Detalles del Campo");
        initGUI(t);
    }

    private void initGUI(TCampo t) {

        int filas = (t instanceof TCampoInterior || t instanceof TCampoExterior) ? 4 : 3;
        JPanel panelPrincipal = new JPanel(new GridLayout(filas, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        panelPrincipal.add(new JLabel("ID: " + t.getID()));
        panelPrincipal.add(new JLabel("Superficie: " + t.getTipoSuperficie()));


        if (t instanceof TCampoInterior) {
            TCampoInterior interior = (TCampoInterior) t;
            String acondicionado = interior.getAcondicionado() ? "Sí" : "No";
            panelPrincipal.add(new JLabel("Aire Acondicionado: " + acondicionado));
        } 
        else if (t instanceof TCampoExterior) {
            TCampoExterior exterior = (TCampoExterior) t;
            panelPrincipal.add(new JLabel("Clima: " + exterior.getClima()));
        }

        //Botón con ActionListener 
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.add(btnCerrar, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}