package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	private static final String readall = "SELECT * FROM provincias ";

	@Override
	public ArrayList<Provincia> obtenerProvincias() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Provincia provincia = new Provincia();
				provincia.setCodigo(resultSet.getInt("CODIGO"));
				provincia.setDescripcion(resultSet.getString("DESCRIPCION"));
				provincias.add(provincia);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincias;
	}
}
