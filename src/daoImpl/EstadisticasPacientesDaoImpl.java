package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EstadisticasPacientesDao;
import entidad.EstadisticasPacientes;
import excepciones.ReadAllException;

public class EstadisticasPacientesDaoImpl implements EstadisticasPacientesDao {

	private static final String readRangoEdades = "SELECT\r\n" + 
			"  CASE\r\n" + 
			"    WHEN TIMESTAMPDIFF(YEAR, fecha_nac, CURDATE()) BETWEEN 0 AND 12 THEN '0-12 años'\r\n" + 
			"    WHEN TIMESTAMPDIFF(YEAR, fecha_nac, CURDATE()) BETWEEN 13 AND 20 THEN '13-20 años'\r\n" + 
			"    WHEN TIMESTAMPDIFF(YEAR, fecha_nac, CURDATE()) BETWEEN 21 AND 40 THEN '21-40 años'\r\n" + 
			"    ELSE 'Más de 40 años'\r\n" + 
			"  END AS rango_edad,\r\n" + 
			"  COUNT(*) AS cantidad_registros\r\n" + 
			"FROM\r\n" + 
			"  pacientes\r\n" + 
			"GROUP BY\r\n" + 
			"  rango_edad;";
	
	private static final String readTurnosXEspecialidades = "SELECT year(DIA) AS ANIO_TURNO, month(DIA) AS MES_TURNO, ESP.DESCRIPCION AS ESPECIALIDAD_TURNO, COUNT(*) AS CANTIDAD_TURNO \r\n" + 
			"FROM TURNOS T\r\n" + 
			"INNER JOIN ESPECIALIDADES ESP ON ESP.CODIGO = T.COD_ESPECIALIDAD\r\n" + 
			"where T.cod_paciente is not null and T.estado = 1\r\n" + 
			"GROUP BY ANIO_TURNO, MES_TURNO, ESPECIALIDAD_TURNO;";
	
	@Override
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasRangoEdades() throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<EstadisticasPacientes> estadisticas = new ArrayList<EstadisticasPacientes>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readRangoEdades);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				EstadisticasPacientes estadistica = new EstadisticasPacientes();
				estadistica.setRangoEdad(resultSet.getString("rango_edad"));
				estadistica.setCantidadRangoEdad(resultSet.getInt("cantidad_registros"));
				estadisticas.add(estadistica);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		return estadisticas;
	}

	@Override
	public ArrayList<EstadisticasPacientes> obtenerEstadisticasTurnosXEsp() throws ReadAllException {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<EstadisticasPacientes> estadisticas = new ArrayList<EstadisticasPacientes>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readTurnosXEspecialidades);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				EstadisticasPacientes estadistica = new EstadisticasPacientes();
				estadistica.setAnioTurno(resultSet.getInt("ANIO_TURNO"));
				estadistica.setMesTurno(resultSet.getInt("MES_TURNO"));
				estadistica.setEspecialidadTurno(resultSet.getString("ESPECIALIDAD_TURNO"));
				estadistica.setCantidadTurno(resultSet.getInt("CANTIDAD_TURNO"));				
				estadisticas.add(estadistica);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ReadAllException();
		}
		return estadisticas;
	}

}
