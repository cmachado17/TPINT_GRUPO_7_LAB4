package negocio;

import java.util.ArrayList;

import entidad.Medico;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public interface MedicoNegocio {
	
	public boolean insert(Medico medico) throws InsertException;
	public boolean delete(int dni) throws DeleteException;
	public boolean update(Medico medico)throws UpdateException;
	public ArrayList<Medico> readAll()throws ReadAllException;
	public Medico buscarMedico(String dni) throws BuscarException;
	public ArrayList<Medico> medicosPorEspecialidad(int especialidad)throws ReadAllException;
}
