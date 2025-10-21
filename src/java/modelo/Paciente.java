package modelo;

public class Paciente {

    // Variables tipo privadas (datos de los usuarios de la web)
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String mensaje;

    // Constructor sin DATOS
    public Paciente() {
    }

    // Constructor con DATOS
    public Paciente(String nombre, String email, String telefono, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.mensaje = mensaje;
    }

    // Metodos Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + '}';
    }
}
