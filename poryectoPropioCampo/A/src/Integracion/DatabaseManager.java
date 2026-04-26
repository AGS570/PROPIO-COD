package Integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static DatabaseManager instance;

    private static final String URL = System.getenv().getOrDefault(
        "CAMPO_DB_URL",
        "jdbc:mysql://localhost:3306/is2deportes?serverTimezone=UTC"
    );
    private static final String USER = System.getenv().getOrDefault("CAMPO_DB_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("CAMPO_DB_PASSWORD", "root");

    private Connection connection;

    private DatabaseManager() {
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                inicializarEsquema(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo abrir la conexión de base de datos", e);
        }
    }

    public synchronized void cerrar() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
                // No relanzamos para no romper el cierre de la app.
            }
        }
    }

    private void inicializarEsquema(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS campo (
                id VARCHAR(64) PRIMARY KEY,
                ocupado BOOLEAN NOT NULL,
                tipo_superficie VARCHAR(100) NOT NULL,
                tipo_campo VARCHAR(20) NOT NULL,
                acondicionado BOOLEAN NULL,
                clima VARCHAR(100) NULL,
                activo BOOLEAN NOT NULL DEFAULT TRUE
            )
            """;

        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }
}
