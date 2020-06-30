package idao;

import java.util.List;

import modelo.FormularioRegistroAccidentes;

public interface IFormularioAccidentesDao {

	public boolean crearRegistroAccidente(FormularioRegistroAccidentes registro);
	//Colocar filtro para que muestre registros según idUsuario
	public List<FormularioRegistroAccidentes> leerRegistrosAccidentes();
	public boolean actualizarRegistroAccidente(FormularioRegistroAccidentes registro);
	public boolean eliminarRegistroAccidente(FormularioRegistroAccidentes registro);
}
