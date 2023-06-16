package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NacionalidadDao;
import entidad.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao{

	private static final String readall = "SELECT * FROM nacionalidades ";
	
	@Override
	public ArrayList<Nacionalidad> obtenerNacionalidades() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Nacionalidad nacionalidad = new Nacionalidad();
				nacionalidad.setCodigo(resultSet.getInt("CODIGO"));
				nacionalidad.setDescripcion(resultSet.getString("DESCRIPCION"));
				nacionalidades.add(nacionalidad);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nacionalidades;
	}
	

}
