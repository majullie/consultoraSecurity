package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FormularioRegistroAccidenteDao;
import modelo.FormularioRegistroAccidentes;

/**
 * Servlet implementation class EliminarRegistroAccidente
 */
public class EliminarRegistroAccidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRegistroAccidente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regid= Integer.parseInt(request.getParameter("idAccidentes"));
		FormularioRegistroAccidentes reg = new FormularioRegistroAccidentes();
		reg.setIdAccidentes(regid);
		
		FormularioRegistroAccidenteDao regdao = new FormularioRegistroAccidenteDao();
		boolean elimino = regdao.eliminarRegistroAccidente(reg);
		
		List<FormularioRegistroAccidentes> registroEliminar = new ArrayList<FormularioRegistroAccidentes>();
		registroEliminar=regdao.leerRegistrosAccidentes();
		
		String mensaje = "";
	
		if(elimino)
			mensaje =  " El registro ha sido eliminado existosamente";
		else
			mensaje = "Ocurrió un problema al eliminar el mensaje";
		
		request.setAttribute("cumensaje", mensaje);
		request.setAttribute("listadoRegistroAccidente", registroEliminar);
		request.getRequestDispatcher("FormRegAccidente.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
