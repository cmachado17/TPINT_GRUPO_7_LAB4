package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EspecialidadesDao;
import entidad.Especialidad;
import excepciones.ReadAllException;

public class EspecialidadesDaoImpl implements EspecialidadesDao{

private static final String readall = "SELECT * FROM especialidades ";
	
	@Override
	public ArrayList<Especialidad> obtenerEspecialidades() throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Especialidad especialidad = new Especialidad();
				especialidad.setCodigo(resultSet.getInt("CODIGO"));
				especialidad.setDescripcion(resultSet.getString("DESCRIPCION"));
				especialidades.add(especialidad);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		return especialidades;
	}


}
