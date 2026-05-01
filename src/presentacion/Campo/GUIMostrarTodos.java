package presentacion.Campo;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import Negocio.Campo.TCampo;


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