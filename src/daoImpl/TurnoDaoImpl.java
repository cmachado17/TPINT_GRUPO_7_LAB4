package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TurnosDao;
import entidad.Medico;
import entidad.Turno;

public class TurnoDaoImpl implements TurnosDao {
	
	private static final String insert  = "CALL INSERTTURNOS(?,?,?,?,?)";

	@Override
	public boolean insert(Medico medico) {
		Connection conexion = null;
		conexion=Conexion.getConexion().getSQLConexion();
		
		boolean isOk = false;
		
		try{
			CallableStatement statement = conexion.prepareCall(insert);
			statement.setInt(1, medico.getDni());
			statement.setInt(2, medico.getDiaAtencion().getCodigo());
			statement.setString(3, medico.getHorarioInicioAtencion());
			statement.setString(4, medico.getHorarioFinAtencion());
			statement.setInt(5, medico.getEspecialidad().getCodigo());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isOk = true;
			}
		}catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isOk;

	}

	@Override
	public ArrayList<Turno> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
