package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidad.TipoUsuario;
import entidad.Usuario;
import excepciones.ReadAllException;

public class UsuarioDaoImpl implements UsuarioDao {


	private static final String Usuario= "SELECT U.DNI, U.COD_TIPOSUSUARIO, TU.DESCRIPCION FROM USUARIOS U INNER JOIN "
			+ "TIPOS_USUARIO TU ON TU.CODIGO = U.COD_TIPOSUSUARIO WHERE U.DNI = ? AND U.CONTRASENIA = ?";

	public Usuario Login(Usuario usuario) throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		Usuario encontrado = new Usuario();

		TipoUsuario encontradoTipoUsuario = new TipoUsuario();

		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(Usuario);
			statement.setInt(1,usuario.getDni());
			statement.setString(2,usuario.getClave());
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				encontrado.setDni(resultSet.getInt("U.DNI"));
				encontradoTipoUsuario.setCodigoTipoUsuario(resultSet.getInt("U.COD_TIPOSUSUARIO"));
				encontradoTipoUsuario.setDescripcion(resultSet.getString("TU.DESCRIPCION"));
				
				encontrado.setTipoUser(encontradoTipoUsuario);
			}else {
				encontrado = null;
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		
		return encontrado;
	}

}
