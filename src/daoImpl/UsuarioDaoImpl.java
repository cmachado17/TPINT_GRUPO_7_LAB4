package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {


	private static final String Usuario= "SELECT DNI FROM USUARIOS WHERE DNI = ? AND CONTRASENIA = ?";

	public int Login(Usuario usuario) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Usuario encontrado = new Usuario();
		int filas=0;
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(Usuario);
			statement.setInt(1,usuario.getDni());
			statement.setString(2,usuario.getClave());
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				encontrado.setDni(resultSet.getInt(1));
				filas=encontrado.getDni();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return filas;
	}

}
