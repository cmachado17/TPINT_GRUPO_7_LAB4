package negocioImpl;

import java.util.ArrayList;

import dao.PacienteDao;
import daoImpl.PacienteDaoImpl;
import entidad.Paciente;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;
import negocio.PacienteNegocio;

public class PacienteNegocioImpl implements PacienteNegocio{
	
	PacienteDao pDao = new PacienteDaoImpl();
			

	@Override
	public boolean insert(Paciente paciente) throws InsertException {
		boolean estado=false;
		if(paciente.getDni()> 0 && paciente.getNombre().trim().length()>0 
			&& paciente.getApellido().trim().length()>0 && paciente.getSexo().trim().length()>0
			&& paciente.getNacionalidad().getCodigo()>0 && paciente.getFechaNacimiento() != null
			&& paciente.getDireccion().trim().length()>0 && paciente.getLocalidad().trim().length()>0
			&& paciente.getProvincia().getCodigo()>0 && paciente.getEmail().trim().length()>0
			&& paciente.getTelefono().trim().length()>0)
		{
			estado = pDao.insert(paciente);
		}
		return estado;
	}

	@Override
	public boolean delete(int dni) throws DeleteException {
		boolean estado=false;
		if(dni > 0)
		{
			estado = pDao.delete(dni);
		}
		return estado;
	}

	@Override
	public boolean update(Paciente paciente) throws UpdateException {
		boolean estado=false;
		if(paciente.getDni()> 0 && paciente.getNombre().trim().length()>0 
				&& paciente.getApellido().trim().length()>0 && paciente.getSexo().trim().length()>0
				&& paciente.getNacionalidad().getCodigo()>0 && paciente.getFechaNacimiento() != null
				&& paciente.getDireccion().trim().length()>0 && paciente.getLocalidad().trim().length()>0
				&& paciente.getProvincia().getCodigo()>0 && paciente.getEmail().trim().length()>0
				&& paciente.getTelefono().trim().length()>0)
		{
			estado = pDao.update(paciente);
		}
		return estado;
	}

	@Override
	public ArrayList<Paciente> readAll() throws ReadAllException {
		
		return pDao.readAll();
	}

	@Override
	public boolean dniNoExiste(Paciente paciente) throws BuscarException {
		if(pDao.dniNoExiste(paciente)==0) {
			return true;
		}
		return false;
	}

	@Override
	public Paciente buscarPaciente(String dni) throws BuscarException {
		return pDao.BuscarPaciente(dni);
	}

}
