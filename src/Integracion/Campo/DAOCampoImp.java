

package Integracion.Campo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Integracion.DatabaseManager;
import Negocio.Campo.TCampo;
import Negocio.Campo.TCampoExterior;
import Negocio.Campo.TCampoInterior;

public class DAOCampoImp implements DAOCampo {

    private Connection getConnection() throws SQLException {
        return DatabaseManager.getInstance().getConnection();
    }

    private int parseId(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public int create(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null) return -1;

        int idCampo = parseId(tCampo.getID());
        if (idCampo < 0) return -1;

        String sqlCampo = "INSERT INTO Campo (id_campo, ocupado, tipo_superficie) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement psCampo = conn.prepareStatement(sqlCampo)) {

            psCampo.setInt(1, idCampo);
            psCampo.setBoolean(2, tCampo.getOcupado());
            psCampo.setString(3, tCampo.getTipoSuperficie());

            int filas = psCampo.executeUpdate();
            if (filas <= 0) return -1;

            if (tCampo instanceof TCampoInterior) {
                String sqlInterior = "INSERT INTO Campo_Interno (id_campo, acondicionado) VALUES (?, ?)";
                try (PreparedStatement psInterior = conn.prepareStatement(sqlInterior)) {
                    psInterior.setInt(1, idCampo);
                    psInterior.setBoolean(2, ((TCampoInterior) tCampo).getAcondicionado());
                    if (psInterior.executeUpdate() <= 0) return -1;
                }
            } else if (tCampo instanceof TCampoExterior) {
                String sqlExterior = "INSERT INTO Campo_Externo (id_campo, clima) VALUES (?, ?)";
                try (PreparedStatement psExterior = conn.prepareStatement(sqlExterior)) {
                    psExterior.setInt(1, idCampo);
                    psExterior.setString(2, ((TCampoExterior) tCampo).getClima());
                    if (psExterior.executeUpdate() <= 0) return -1;
                }
            }

            return idCampo;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public TCampo read(String id) {
        int idCampo = parseId(id);
        if (idCampo < 0) return null;

        String sql = "SELECT c.id_campo, c.ocupado, c.tipo_superficie, ci.acondicionado, ce.clima "
                + "FROM Campo c "
                + "LEFT JOIN Campo_Interno ci ON c.id_campo = ci.id_campo "
                + "LEFT JOIN Campo_Externo ce ON c.id_campo = ce.id_campo "
                + "WHERE c.id_campo = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCampo);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                String idStr = String.valueOf(rs.getInt("id_campo"));
                boolean ocupado = rs.getBoolean("ocupado");
                String tipoSuperficie = rs.getString("tipo_superficie");

                boolean isInterior = rs.getObject("acondicionado") != null;
                boolean isExterior = rs.getString("clima") != null;

                if (isInterior) {
                    return new TCampoInterior(idStr, ocupado, tipoSuperficie, rs.getBoolean("acondicionado"));
                } else if (isExterior) {
                    return new TCampoExterior(idStr, ocupado, tipoSuperficie, rs.getString("clima"));
                }

                return new TCampo(idStr, ocupado, tipoSuperficie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Collection<TCampo> readAll() {
        Collection<TCampo> lista = new ArrayList<>();
        String sql = "SELECT c.id_campo, c.ocupado, c.tipo_superficie, ci.acondicionado, ce.clima "
                + "FROM Campo c "
                + "LEFT JOIN Campo_Interno ci ON c.id_campo = ci.id_campo "
                + "LEFT JOIN Campo_Externo ce ON c.id_campo = ce.id_campo";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String idStr = String.valueOf(rs.getInt("id_campo"));
                boolean ocupado = rs.getBoolean("ocupado");
                String tipoSuperficie = rs.getString("tipo_superficie");

                boolean isInterior = rs.getObject("acondicionado") != null;
                boolean isExterior = rs.getString("clima") != null;

                if (isInterior) {
                    lista.add(new TCampoInterior(idStr, ocupado, tipoSuperficie, rs.getBoolean("acondicionado")));
                } else if (isExterior) {
                    lista.add(new TCampoExterior(idStr, ocupado, tipoSuperficie, rs.getString("clima")));
                } else {
                    lista.add(new TCampo(idStr, ocupado, tipoSuperficie));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public int update(TCampo tCampo) {
        if (tCampo == null || tCampo.getID() == null) return -1;

        int idCampo = parseId(tCampo.getID());
        if (idCampo < 0) return -1;

        String sqlCampo = "UPDATE Campo SET ocupado = ?, tipo_superficie = ? WHERE id_campo = ?";

        try (Connection conn = getConnection();
             PreparedStatement psCampo = conn.prepareStatement(sqlCampo)) {

            psCampo.setBoolean(1, tCampo.getOcupado());
            psCampo.setString(2, tCampo.getTipoSuperficie());
            psCampo.setInt(3, idCampo);

            int filas = psCampo.executeUpdate();
            if (filas <= 0) return -1;

            if (tCampo instanceof TCampoInterior) {
                String sqlInterior = "UPDATE Campo_Interno SET acondicionado = ? WHERE id_campo = ?";
                try (PreparedStatement psInterior = conn.prepareStatement(sqlInterior)) {
                    psInterior.setBoolean(1, ((TCampoInterior) tCampo).getAcondicionado());
                    psInterior.setInt(2, idCampo);
                    psInterior.executeUpdate();
                }
            } else if (tCampo instanceof TCampoExterior) {
                String sqlExterior = "UPDATE Campo_Externo SET clima = ? WHERE id_campo = ?";
                try (PreparedStatement psExterior = conn.prepareStatement(sqlExterior)) {
                    psExterior.setString(1, ((TCampoExterior) tCampo).getClima());
                    psExterior.setInt(2, idCampo);
                    psExterior.executeUpdate();
                }
            }

            return idCampo;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String id) {
        int idCampo = parseId(id);
        if (idCampo < 0) return -1;

        try (Connection conn = getConnection()) {
            try (PreparedStatement psInt = conn.prepareStatement("DELETE FROM Campo_Interno WHERE id_campo = ?")) {
                psInt.setInt(1, idCampo);
                psInt.executeUpdate();
            }

            try (PreparedStatement psExt = conn.prepareStatement("DELETE FROM Campo_Externo WHERE id_campo = ?")) {
                psExt.setInt(1, idCampo);
                psExt.executeUpdate();
            }

            try (PreparedStatement psCampo = conn.prepareStatement("DELETE FROM Campo WHERE id_campo = ?")) {
                psCampo.setInt(1, idCampo);
                return psCampo.executeUpdate() > 0 ? idCampo : -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Collection<TCampo> readCamposMantenimiento() {
        Collection<TCampo> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT c.id_campo, c.ocupado, c.tipo_superficie, ci.acondicionado, ce.clima "
                + "FROM Campo c "
                + "JOIN Encargado_Mantenimiento em ON c.id_campo = em.id_campo "
                + "LEFT JOIN Campo_Interno ci ON c.id_campo = ci.id_campo "
                + "LEFT JOIN Campo_Externo ce ON c.id_campo = ce.id_campo";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String idStr = String.valueOf(rs.getInt("id_campo"));
                boolean ocupado = rs.getBoolean("ocupado");
                String tipoSuperficie = rs.getString("tipo_superficie");

                boolean isInterior = rs.getObject("acondicionado") != null;
                boolean isExterior = rs.getString("clima") != null;

                if (isInterior) {
                    lista.add(new TCampoInterior(idStr, ocupado, tipoSuperficie, rs.getBoolean("acondicionado")));
                } else if (isExterior) {
                    lista.add(new TCampoExterior(idStr, ocupado, tipoSuperficie, rs.getString("clima")));
                } else {
                    lista.add(new TCampo(idStr, ocupado, tipoSuperficie));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}