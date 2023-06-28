package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DiaSemanaDao;
import entidad.DiaSemana;
import excepciones.ReadAllException;

public class DiaSemanaDaoImpl implements DiaSemanaDao {

private static final String readall = "SELECT * FROM diasemana ";
	
	@Override
	public ArrayList<DiaSemana> obtenerDiaSemana() throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<DiaSemana> diasSemana = new ArrayList<DiaSemana>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				DiaSemana diasemana = new DiaSemana();
				diasemana.setCodigo(resultSet.getInt("CODIGO"));
				diasemana.setDescripcion(resultSet.getString("DESCRIPCION"));
				diasSemana.add(diasemana);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		return diasSemana;
	}

}
