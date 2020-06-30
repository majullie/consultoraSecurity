package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import conectar.ConexionSingleton;
import modelo.FormularioRegistroAccidentes;
import idao.IFormularioAccidentesDao;

public class FormularioRegistroAccidenteDao implements IFormularioAccidentesDao {

	@Override
	public boolean crearRegistroAccidente(FormularioRegistroAccidentes registro) {
		// TODO Auto-generated method stub
		
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO formaccidentes VALUES (null,'" + registro.getNombre() + "','"+ registro.getApellido()+"','"+registro.getAreaAccidente()+"')";
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase FormularioRegistroAccidenteDao, método crearRegistros ");
			e.printStackTrace();
		}
		
		return registrar;	
		
	}

	@Override
	public List<FormularioRegistroAccidentes> leerRegistrosAccidentes() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "select * from formaccidentes ORDER BY IDACCIDENTES";
		
		List<FormularioRegistroAccidentes> listaRegistros = new ArrayList<FormularioRegistroAccidentes>();
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				FormularioRegistroAccidentes c = new FormularioRegistroAccidentes();
				c.setIdAccidentes(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setAreaAccidente(rs.getString(4));
				listaRegistros.add(c);
			}
			stm.close();
			rs.close();
			//con.close();
		} catch(SQLException e) {
			System.out.println("Error: Clase FormularioRegistroAccidenteDao, método leerRegistros ");
			e.printStackTrace();
		}
		
		return listaRegistros;
	}

	@Override
	public boolean actualizarRegistroAccidente(
			FormularioRegistroAccidentes registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarRegistroAccidente(
			FormularioRegistroAccidentes registro) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		
		boolean eliminar = false;
		
		String sql = "DELETE FROM formaccidentes WHERE id = " + registro.getIdAccidentes();
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase FormularioRegistroAccidentes, método eliminarRegistro");
			e.printStackTrace();
		}
		
		return eliminar;
	}

}
