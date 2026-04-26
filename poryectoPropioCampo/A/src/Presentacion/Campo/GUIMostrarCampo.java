package Presentacion.Campo;

import javax.swing.*;

import Negocio.campo.TCampo;
import Negocio.campo.TCampoExterior;
import Negocio.campo.TCampoInterior;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMostrarCampo extends JFrame {

    public GUIMostrarCampo(TCampo t) {
        super("Detalles del Campo");
        initGUI(t);
    }

    private void initGUI(TCampo t) {
        // Usamos un GridLayout dinámico: 3 filas base + 1 si es específico
        int filas = (t instanceof TCampoInterior || t instanceof TCampoExterior) ? 4 : 3;
        JPanel panelPrincipal = new JPanel(new GridLayout(filas, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Información común a todos los campos
        panelPrincipal.add(new JLabel("ID: " + t.getID()));
        panelPrincipal.add(new JLabel("Superficie: " + t.getTipoSuperficie()));

        // Lógica para diferenciar tipos en la misma vista
        if (t instanceof TCampoInterior) {
            TCampoInterior interior = (TCampoInterior) t;
            String acondicionado = interior.getAcondicionado() ? "Sí" : "No";
            panelPrincipal.add(new JLabel("Aire Acondicionado: " + acondicionado));
        } 
        else if (t instanceof TCampoExterior) {
            TCampoExterior exterior = (TCampoExterior) t;
            panelPrincipal.add(new JLabel("Clima: " + exterior.getClima()));
        }

        // Botón de cierre con ActionListener interno
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