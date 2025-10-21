package dao;

// Importamos las conexiones y herramientas SQL
import modelo.Paciente;
import modelo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // Metodo: Insertar nuevos pacientes
    public boolean insertarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, email, telefono, mensaje) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getEmail());
            pstmt.setString(3, paciente.getTelefono());
            pstmt.setString(4, paciente.getMensaje());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar paciente... " + e.getMessage());
            return false;
        }
    }

    // Metodo: Obtener todos los pacientes
    public List<Paciente> obtenerTodosPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try (Connection conn = ConexionBD.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setMensaje(rs.getString("mensaje"));

                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener pacientes..." + e.getMessage());
        }
        return pacientes;
    }

    // Metodo: Obtener paciente por ID
    public Paciente obtenerPacientePorId(int id) {
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        Paciente paciente = null;

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener paciente: " + e.getMessage());
        }
        return paciente;
    }

    // Metodo para ctualizar paciente (se usan boleanos para evitar errores)
    public boolean actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE pacientes SET nombre = ?, email = ?, telefono = ?, mensaje = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getEmail());
            pstmt.setString(3, paciente.getTelefono());
            pstmt.setString(4, paciente.getMensaje());
            pstmt.setInt(5, paciente.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }

    // Metodo: Eliminar pacientes
    public boolean eliminarPaciente(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }
}
