package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EmpleadoDao;
import entidad.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {
	
	private static final String Usuario= "SELECT * FROM EMPLEADOS WHERE EMAIL = ? AND CLAVE = ?";

	@Override
	public ArrayList<Empleado> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
