package Integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    // ATENCIÓN: Debes modificar estas constantes con los datos reales de tu servidor
    private static final String URL = "jdbc:mysql://localhost:3306/IS2deportes";
    private static final String USER = "deportes_user";
    private static final String PASSWORD = "deportes1234";

    private DatabaseManager() {
        try {
            // El driver se carga automáticamente en versiones modernas de JDBC.
            // Si usas una versión antigua, descomenta y ajusta la siguiente línea:
            // Class.forName("com.mysql.cj.jdbc.Driver");

            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error critico: Fallo al establecer la conexion con la base de datos.");
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        try {
            if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
                instance = new DatabaseManager();
            }
        } catch (SQLException e) {
            System.err.println("Error critico: Fallo al verificar el estado de la conexion.");
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}