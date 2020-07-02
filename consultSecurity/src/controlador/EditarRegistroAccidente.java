package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FormularioRegistroAccidentes;
import dao.FormularioRegistroAccidenteDao;

/**
 * Servlet implementation class EditarRegistroAccidente
 */
public class EditarRegistroAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarRegistroAccidente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int registroId = Integer.parseInt(request.getParameter("idAccidentes"));
		
		FormularioRegistroAccidenteDao regDao = new FormularioRegistroAccidenteDao();
		FormularioRegistroAccidentes reg = new FormularioRegistroAccidentes();
		
		reg = regDao.obtenerRegistroAccidente(registroId);
		
		request.setAttribute("registros", reg);
		request.getRequestDispatcher("EditarRegAccidente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("txtnombre");
		String apellido = request.getParameter("txtapellido");
		String area = request.getParameter("txtarea");
		int id = Integer.parseInt(request.getParameter("hdnidusuario"));

		FormularioRegistroAccidentes regist = new FormularioRegistroAccidentes(id,nombre,apellido,area);
		
		FormularioRegistroAccidenteDao registdao = new FormularioRegistroAccidenteDao();
		boolean editar = registdao.actualizarRegistroAccidente(regist);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El usuario se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el usuario";

		request.setAttribute("datosregistro", regist);
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("EditarRegAccidente.jsp").forward(request, response);
		
	}

}
