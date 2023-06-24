package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidad.Persona;
import entidad.TipoUsuario;
import entidad.Usuario;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public class UsuarioDaoImpl implements UsuarioDao {


	private static final String Usuario= "SELECT U.DNI, U.COD_TIPOSUSUARIO, TU.DESCRIPCION FROM USUARIOS U INNER JOIN "
			+ "TIPOS_USUARIO TU ON TU.CODIGO = U.COD_TIPOSUSUARIO WHERE U.DNI = ? AND U.CONTRASENIA = ?";
	private static final String insert  = "insert into usuarios(dni, contrasenia, cod_tiposusuario, estado) VALUES (?, ?, ?, ?)";
	private static final String update  = "UPDATE usuarios SET CONTRASENIA = ? , COD_TIPOSUSUARIO = ?, ESTADO = ? WHERE Dni = ?";

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
	
	@Override
	public boolean insert(Usuario usuario) throws InsertException {
		
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try
		{		
			PreparedStatement statement = conexion.prepareStatement(insert);
			statement.setInt(1, usuario.getDni());
			statement.setString(2, usuario.getClave());
			statement.setInt(3, usuario.getTipoUser().getCodigoTipoUsuario());
			statement.setBoolean(4, usuario.isEstado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new InsertException();
			}
		}
		
		return isOk;
	}

	@Override
	public boolean update(Usuario usuario) throws UpdateException {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isOk = false;
		try
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, usuario.getClave());
			statement.setInt(2, usuario.getTipoUser().getCodigoTipoUsuario());
			statement.setBoolean(3, usuario.isEstado());
			statement.setInt(4, usuario.getDni());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UpdateException();
			}
		}
		return isOk;
	}
}
