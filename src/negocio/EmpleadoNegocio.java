package negocio;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Persona;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public interface EmpleadoNegocio {

	public boolean insert(Persona empleado) throws InsertException;
	public boolean insertMedicosPorEspecialidad(Medico medico) throws InsertException;
	public boolean delete(int dni) throws DeleteException;
	public boolean bajaFisica(int dni) throws DeleteException;
	public boolean liberarTurnos(int dni);
	public boolean anularTurnos(int dni, String fechaInicio, String fechaFin);
	public boolean update(Persona empleado) throws UpdateException;
	public ArrayList<Persona> readAll() throws ReadAllException;
	public int dniNoExiste(Persona empleado) throws BuscarException;
	public Persona BuscarEmpleado(String dni) throws BuscarException;
	public boolean updateMedicosEspecialidad(Medico medico) throws UpdateException;
}
