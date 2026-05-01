package Integracion.IntegracionMantenimiento;

import java.sql.Connection;
import Negocio.NegocioMantenimiento.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.DatabaseManager;
import Negocio.NegocioMantenimiento.*;
public class DAOMantenimientoImp implements DAOMantenimiento {

    private Connection getConnection() throws SQLException {
        return DatabaseManager.getInstance().getConnection();
    }

    @Override
    public int create(TMantenimiento mantenimiento) {
        int idGenerado = -1;
        String sql = "INSERT INTO Mantenimiento (id_persona, tipo_mantenimiento) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, mantenimiento.getId());
            ps.setString(2, mantenimiento.getTipoMantenimiento());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                idGenerado = mantenimiento.getId();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return idGenerado;
    }

    @Override
    public TMantenimiento read(int id) {
        TMantenimiento mantenimiento = null;

        String sql = "SELECT p.id_persona, p.dni, p.nombre, p.telefono, e.salario, m.tipo_mantenimiento " +
                "FROM Persona p " +
                "JOIN Empleado e ON p.id_persona = e.id_persona " +
                "JOIN Mantenimiento m ON e.id_persona = m.id_persona " +
                "WHERE m.id_persona = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mantenimiento = new TMantenimiento(
                            rs.getInt("id_persona"),
                            rs.getString("dni"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getDouble("salario"),
                            rs.getString("tipo_mantenimiento")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mantenimiento;
    }

    @Override
    public List<TMantenimiento> readAll() {
        List<TMantenimiento> lista = new ArrayList<>();
        String sql = "SELECT p.id_persona, p.dni, p.nombre, p.telefono, e.salario, m.tipo_mantenimiento " +
                "FROM Persona p " +
                "JOIN Empleado e ON p.id_persona = e.id_persona " +
                "JOIN Mantenimiento m ON e.id_persona = m.id_persona";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new TMantenimiento(
                        rs.getInt("id_persona"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getDouble("salario"),
                        rs.getString("tipo_mantenimiento")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean update(TMantenimiento mantenimiento) {
        boolean actualizado = false;
        String sql = "UPDATE Mantenimiento SET tipo_mantenimiento = ? WHERE id_persona = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mantenimiento.getTipoMantenimiento());
            ps.setInt(2, mantenimiento.getId());

            actualizado = ps.executeUpdate() > 0;
            // Ojo: Si quieres actualizar nombre o salario, necesitas sentencias separadas para Persona y Empleado.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actualizado;
    }

    @Override
    public boolean delete(int id) {
        boolean borrado = false;
        String sql = "DELETE FROM Mantenimiento WHERE id_persona = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            borrado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrado;
    }
}