package negocio;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Persona;

public interface EmpleadoNegocio {

	public boolean insert(Persona empleado);
	public boolean insertMedicosPorEspecialidad(Medico medico);
	public boolean delete(int dni);
	public boolean update(Persona empleado);
	public ArrayList<Persona> readAll();
	public int dniNoExiste(Persona empleado);
	public Persona BuscarEmpleado(String dni);
}
