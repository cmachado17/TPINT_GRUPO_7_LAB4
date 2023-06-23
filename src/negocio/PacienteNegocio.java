package negocio;

import java.util.ArrayList;

import entidad.Paciente;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;


public interface PacienteNegocio {

	public boolean insert(Paciente paciente) throws InsertException;
	public boolean delete(int dni) throws DeleteException;
	public boolean update(Paciente paciente) throws UpdateException;
	public ArrayList<Paciente> readAll() throws ReadAllException;
	public boolean dniNoExiste(Paciente paciente) throws BuscarException;
	public Paciente buscarPaciente(String dni) throws BuscarException;
}
