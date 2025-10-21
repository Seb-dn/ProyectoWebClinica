package modelo;

// Importa el (tiempo) del envio de los datos del usuario a la base de datos desde mi XAMPP
import java.sql.Timestamp;

public class Usuario {

    // Variables tipo privadas
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String rol;
    private Timestamp fechaCreacion;

    // Constructor sin DATOS
    public Usuario() {
    }

    // Constructos con DATOS
    public Usuario(String usuario, String contraseña, String rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    // Metodos Getters and Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
