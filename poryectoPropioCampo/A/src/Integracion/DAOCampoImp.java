package Integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Negocio.TCampo;
import Negocio.TCampoExterior;
import Negocio.TCampoInterior;

public class DAOCampoImp implements DAOCampo {

    @Override
    public int create(TCampo t) {
        if (t == null || t.getID() == null || t.getID().isBlank()) {
            return -1;
        }

        String sql = """
            INSERT INTO campo (id, ocupado, tipo_superficie, tipo_campo, acondicionado, clima, activo)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, t.getID());
            ps.setBoolean(2, t.getOcupado());
            ps.setString(3, t.getTipoSuperficie());
            ps.setString(4, getTipoCampo(t));
            if (t instanceof TCampoInterior interior) {
                ps.setBoolean(5, interior.getAcondicionado());
                ps.setString(6, null);
            } else if (t instanceof TCampoExterior exterior) {
                ps.setObject(5, null);
                ps.setString(6, exterior.getClima());
            } else {
                ps.setObject(5, null);
                ps.setString(6, null);
            }
            ps.setBoolean(7, true);

            return ps.executeUpdate() == 1 ? 1 : -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public TCampo read(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        String sql = "SELECT * FROM campo WHERE id = ? AND activo = TRUE";

        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        } catch (SQLException ignored) {
            // Si falla integración, mantenemos contrato retornando null.
        }

        return null;
    }

    @Override
    public Collection<TCampo> readAll() {
        Collection<TCampo> campos = new ArrayList<>();
        String sql = "SELECT * FROM campo WHERE activo = TRUE";

        try (PreparedStatement ps = getConn().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                campos.add(mapear(rs));
            }
        } catch (SQLException ignored) {
            // En error retornamos la colección vacía para no romper presentación.
        }

        return campos;
    }

    @Override
    public int update(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null || tCampo.getID().isBlank()) {
            return -1;
        }

        String sql = """
            UPDATE campo
               SET ocupado = ?,
                   tipo_superficie = ?,
                   tipo_campo = ?,
                   acondicionado = ?,
                   clima = ?
             WHERE id = ? AND activo = TRUE
            """;

        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setBoolean(1, tCampo.getOcupado());
            ps.setString(2, tCampo.getTipoSuperficie());
            ps.setString(3, getTipoCampo(tCampo));
            if (tCampo instanceof TCampoInterior interior) {
                ps.setBoolean(4, interior.getAcondicionado());
                ps.setString(5, null);
            } else if (tCampo instanceof TCampoExterior exterior) {
                ps.setObject(4, null);
                ps.setString(5, exterior.getClima());
            } else {
                ps.setObject(4, null);
                ps.setString(5, null);
            }
            ps.setString(6, tCampo.getID());

            return ps.executeUpdate() == 1 ? 1 : -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int delete(String id) {
        if (id == null || id.isBlank()) {
            return -1;
        }

        String sql = "UPDATE campo SET activo = FALSE WHERE id = ? AND activo = TRUE";

        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() == 1 ? 1 : -1;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public Collection<TCampo> readCamposMantenimiento() {
        Collection<TCampo> camposMantenimiento = new ArrayList<>();
        String sql = "SELECT * FROM campo WHERE activo = TRUE AND ocupado = TRUE";

        try (PreparedStatement ps = getConn().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                camposMantenimiento.add(mapear(rs));
            }
        } catch (SQLException ignored) {
            // En error devolvemos colección vacía.
        }

        return camposMantenimiento;
    }

    private TCampo mapear(ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        boolean ocupado = rs.getBoolean("ocupado");
        String tipoSuperficie = rs.getString("tipo_superficie");
        String tipoCampo = rs.getString("tipo_campo");

        if ("INTERIOR".equalsIgnoreCase(tipoCampo)) {
            boolean acondicionado = rs.getBoolean("acondicionado");
            return new TCampoInterior(id, ocupado, tipoSuperficie, acondicionado);
        }

        if ("EXTERIOR".equalsIgnoreCase(tipoCampo)) {
            String clima = rs.getString("clima");
            return new TCampoExterior(id, ocupado, tipoSuperficie, clima);
        }

        return new TCampo(id, ocupado, tipoSuperficie);
    }

    private String getTipoCampo(TCampo campo) {
        if (campo instanceof TCampoInterior) {
            return "INTERIOR";
        }
        if (campo instanceof TCampoExterior) {
            return "EXTERIOR";
        }
        return "GENERIC";
    }

    private Connection getConn() {
        return DatabaseManager.getInstance().getConnection();
    }
}
