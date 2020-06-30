package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FormularioRegistroAccidenteDao;
import modelo.FormularioRegistroAccidentes;

/**
 * Servlet implementation class CrearRegistroAcc
 */
public class CrearRegistroAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearRegistroAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("CrearRegistroAccidente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("txtnombre");
		String apellido = request.getParameter("txtapellido");
		String area = request.getParameter("txtarea");
		
		FormularioRegistroAccidentes reg = new FormularioRegistroAccidentes(nombre,apellido,area);
		
		FormularioRegistroAccidenteDao regdao = new FormularioRegistroAccidenteDao();
		boolean agregar = regdao.crearRegistroAccidente(reg);
		
		String mensaje="";
		
		if (agregar)
			mensaje = "El usuario se ha creado exitosamente";
		else 
			mensaje = "Ocurrió un error al crear el usuario";
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("CrearRegistroAccidente.jsp").forward(request, response);
	}

}
