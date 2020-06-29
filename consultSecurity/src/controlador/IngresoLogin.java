package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IngresoLogin
 */
public class IngresoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = solicitud.getParameter("usuario");
		String contrasena = solicitud.getParameter("contrasena");
		if ("mjmarina".equals(usuario) && "1234".equals(contrasena)) {
			response(respuesta, "logeo correcto!");
		} else {
			response(respuesta, "logue incorrecto!");
		}
	}
	
	private void response(HttpServletResponse response, String mensaje) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + mensaje + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}

