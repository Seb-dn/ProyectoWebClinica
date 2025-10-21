package dao;

// Importamos las herramientas de SQL
import modelo.Contacto;
import modelo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    // Metodo de guardar contacto del formulario
    public boolean insertarContacto(Contacto contacto) {
        System.out.println("Insercion de contaco:");
        System.out.println("Nombre: " + contacto.getNombre());
        System.out.println("Email: " + contacto.getEmail());
        System.out.println("Teléfono: " + contacto.getTelefono());
        System.out.println("Mensaje: " + (contacto.getMensaje().length() > 50
                ? contacto.getMensaje().substring(0, 50) + "..." : contacto.getMensaje()));

        String sql = "INSERT INTO contactos (nombre, email, telefono, mensaje, fechaRegistro) VALUES (?, ?, ?, ?, NOW())";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            System.out.println("Conexión obtenida, preparando insercion...");

            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getEmail());
            pstmt.setString(3, contacto.getTelefono());
            pstmt.setString(4, contacto.getMensaje());

            System.out.println("Ejecutando INSERT en la base de datos...");
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

            if (filasAfectadas > 0) {
                System.out.println("¡CONTACTO INSERTADO EXITOSAMENTE!");
                return true;
            } else {
                System.out.println("Inserción completada pero 0 filas afectadas");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("ERROR SQL AL INSERTAR CONTACTO:");
            System.err.println("Codigo: " + e.getErrorCode());
            System.err.println("Estado: " + e.getSQLState());
            System.err.println("Mensaje: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("ERROR GENERAL: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}