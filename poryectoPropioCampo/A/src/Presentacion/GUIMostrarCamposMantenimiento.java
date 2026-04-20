package Presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;
import Negocio.TCampo;

public class GUIMostrarCamposMantenimiento extends JFrame {

    public GUIMostrarCamposMantenimiento(Collection<TCampo> lista) {
        super("Campos en Mantenimiento");
        initGUI(lista);
    }

    private void initGUI(Collection<TCampo> lista) {
        String[] columnas = {"ID", "Superficie", "Mantenimiento"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        for (TCampo t : lista) {
            modelo.addRow(new Object[]{ t.getID(), t.getTipoSuperficie(), "SI" });
        }

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        this.add(btnCerrar, BorderLayout.SOUTH);

        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}