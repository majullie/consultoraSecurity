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
		Connection con = null;
		Statement stm = null;
		
		boolean actualizar = false;
		
		String sql = "UPDATE formaccidentes SET nombre = '" + registro.getNombre() + "', apellido = '" + registro.getApellido() + "', areaaccidente = '" + registro.getAreaAccidente() +"' WHERE id = '" + registro.getIdAccidentes() + "'";
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase FormularioAccidentedao, método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;	
		
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

	@Override
	public FormularioRegistroAccidentes obtenerRegistroAccidente(int idAccidente) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "select * from formaccidentes where ID = " + idAccidente;
		
		FormularioRegistroAccidentes u = new FormularioRegistroAccidentes();
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				u.setIdAccidentes(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setAreaAccidente(rs.getString(4));
			}
			stm.close();
			rs.close();
			//con.close();
		} catch(SQLException e) {
			System.out.println("Error: Clase UsuarioDao, método obtenerUsuario ");
			e.printStackTrace();
		}
		
		return u;
	}

}
