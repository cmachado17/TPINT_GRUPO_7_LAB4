package dao;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Persona;


public interface EmpleadoDao {

	public boolean insert(Persona empleado);
	public boolean insertMedicosPorEspecilidad(Medico medico);
	public boolean delete(int dni);
	public boolean update(Persona empleado);
	public ArrayList<Persona> readAll();
	public int dniNoExiste(Persona persona);
	public Persona BuscarEmpleado(String dni);
}
