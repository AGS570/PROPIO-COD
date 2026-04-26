package Presentacion.Campo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Negocio.campo.TCampo;

import java.awt.*;
import java.util.Collection;

public class GUIMostrarTodos extends JFrame {
    
    public GUIMostrarTodos(Collection<TCampo> lista) {
        super("Lista de Todos los Campos");
        initGUI(lista);
    }

    private void initGUI(Collection<TCampo> lista) {
        String[] columnas = {"ID", "Superficie", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);

        for (TCampo t : lista) {
            Object[] fila = { t.getID(), t.getTipoSuperficie(), t.getOcupado() ? "Ocupado" : "Libre" };
            modelo.addRow(fila);
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