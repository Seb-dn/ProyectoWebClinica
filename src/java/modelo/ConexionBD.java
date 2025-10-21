package modelo;

// Importar conexiones del servidor como los drivers y SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Establece la conexion directamente a la base de datos y el puerto
    private static final String URL = "jdbc:mysql://localhost:33065/cuidado vital cr"; // Se agrega el nombre de la base de datos de XAMPP
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Establece dicha conexion con el servidor mediante los drives y el puerto
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado", e);
        }
    }
}
