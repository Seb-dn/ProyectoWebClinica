package controlador;

// Importacion de los recursos de servlet para el funcionamiento del servidor
import dao.ContactoDAO;
import modelo.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Conecta servlet y servidor
@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
    private ContactoDAO contactoDAO;

    @Override
    public void init() throws ServletException {
        contactoDAO = new ContactoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            // Obtener parámetros del formulario:
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String mensaje = request.getParameter("mensaje");

            // Validar campos requeridos: Evita espacios vacios
            if (nombre == null || nombre.trim().isEmpty()
                    || email == null || email.trim().isEmpty()
                    || mensaje == null || mensaje.trim().isEmpty()) {

                enviarError(response, "Todos los campos requeridos deben ser llenados...");
                return;
            }

            // Crear objeto Contacto: permite manipular el objeto contacto
            Contacto contacto = new Contacto();
            contacto.setNombre(nombre.trim());
            contacto.setEmail(email.trim());
            contacto.setTelefono(telefono != null ? telefono.trim() : "");
            contacto.setMensaje(mensaje.trim());

            // Guardar en base de datos: exporta a la base de datos
            boolean exito = contactoDAO.insertarContacto(contacto);

            // Enviar respuesta: confirmacion de la insercion
            enviarRespuesta(response, exito, nombre);

            // Capta errores de problemas de conexion con el servidor
        } catch (Exception e) {
            enviarError(response, "Error interno del servidor: " + e.getMessage());
        }
    }

    // Metodo privado de envio de respuesta del servidor (Incluye un diseño basico para que el usuario vea el error o exito)
    private void enviarRespuesta(HttpServletResponse response, boolean exito, String nombre)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado del Contacto</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container mt-5\">");

        if (exito) {
            out.println("<div class=\"alert alert-success\">");
            out.println("<h4>¡Mensaje enviado con éxito!</h4>");
            out.println("<p>Gracias <strong>" + nombre + "</strong>, nos pondremos en contacto contigo pronto.</p>");
            out.println("</div>");
        } else {
            out.println("<div class=\"alert alert-danger\">");
            out.println("<h4>Error al enviar el mensaje</h4>");
            out.println("<p>Por favor, intenta nuevamente más tarde.</p>");
            out.println("</div>");
        }

        out.println("<a href=\"contacto.html\" class=\"btn btn-primary\">Volver al Formulario</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    // Metodo privado de enviar el error con interfaz visual en caso de falla de conexion con el servidor
    private void enviarError(HttpServletResponse response, String mensaje) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");
        out.println("<h1>Error: " + mensaje + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
