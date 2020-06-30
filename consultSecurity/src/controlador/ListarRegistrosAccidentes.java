package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FormularioRegistroAccidentes;
import dao.FormularioRegistroAccidenteDao;


/**
 * Servlet implementation class ListarRegistrosAccidentes
 */
public class ListarRegistrosAccidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRegistrosAccidentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FormularioRegistroAccidenteDao registrodao = new FormularioRegistroAccidenteDao();
		List<FormularioRegistroAccidentes> lregistros = new ArrayList<FormularioRegistroAccidentes>();
		
		lregistros = registrodao.leerRegistrosAccidentes();
		
		request.setAttribute("listadoRegistroAccidente", lregistros);
		request.getRequestDispatcher("FormRegAccidente.jsp").forward(request, response);
		//response.sendRedirect("http://www.google.cl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
