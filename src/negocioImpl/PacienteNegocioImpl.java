package negocioImpl;

import java.util.ArrayList;

import dao.PacienteDao;
import daoImpl.PacienteDaoImpl;
import entidad.Paciente;
import negocio.PacienteNegocio;

public class PacienteNegocioImpl implements PacienteNegocio{
	
	PacienteDao pDao = new PacienteDaoImpl();
			

	@Override
	public boolean insert(Paciente paciente) {
		boolean estado=false;
		if(paciente.getDni()> 0 && paciente.getNombre().trim().length()>0 
			&& paciente.getApellido().trim().length()>0 && paciente.getSexo().trim().length()>0
			&& paciente.getCodNacionalidad()>0 && paciente.getFechaNacimiento() != null
			&& paciente.getDireccion().trim().length()>0 && paciente.getLocalidad().trim().length()>0
			&& paciente.getProvincia()>0 && paciente.getEmail().trim().length()>0
			&& paciente.getTelefono().trim().length()>0)
		{
			estado = pDao.insert(paciente);
		}
		return estado;
	}

	@Override
	public boolean delete(Paciente paciente_a_eliminar) {
		boolean estado=false;
		if(paciente_a_eliminar.getDni() > 0)
		{
			estado = pDao.delete(paciente_a_eliminar);
		}
		return estado;
	}

	@Override
	public boolean update(Paciente paciente) {
		boolean estado=false;
		if(paciente.getDni()> 0 && paciente.getNombre().trim().length()>0 
				&& paciente.getApellido().trim().length()>0 && paciente.getSexo().trim().length()>0
				&& paciente.getCodNacionalidad()>0 && paciente.getFechaNacimiento() != null
				&& paciente.getDireccion().trim().length()>0 && paciente.getLocalidad().trim().length()>0
				&& paciente.getProvincia()>0 && paciente.getEmail().trim().length()>0
				&& paciente.getTelefono().trim().length()>0)
		{
			estado = pDao.update(paciente);
		}
		return estado;
	}

	@Override
	public ArrayList<Paciente> readAll() {
		
		return pDao.readAll();
	}

	@Override
	public boolean dniNoExiste(Paciente paciente) {
		if(pDao.dniNoExiste(paciente)==0) {
			return true;
		}
		return false;
	}

}
