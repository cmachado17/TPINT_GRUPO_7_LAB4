package negocioImpl;

import java.util.ArrayList;

import dao.EmpleadoDao;
import daoImpl.EmpleadoDaoImpl;
import entidad.Medico;
import entidad.Persona;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;
import negocio.EmpleadoNegocio;

public class EmpleadoNegocioImpl implements EmpleadoNegocio {

	EmpleadoDao eDao = new EmpleadoDaoImpl();
	
	@Override
	public boolean insert(Persona empleado) throws InsertException {
		return eDao.insert(empleado);
	}

	@Override
	public boolean insertMedicosPorEspecialidad(Medico medico) throws InsertException {
		return eDao.insertMedicosPorEspecialidad(medico);
	}

	@Override
	public boolean delete(int dni) throws DeleteException {
		return eDao.delete(dni);
	}
	
	@Override
	public boolean bajaFisica(int dni) throws DeleteException {
		return eDao.bajaFisica(dni);
	}

	@Override
	public boolean update(Persona empleado) throws UpdateException {
		return eDao.update(empleado);
	}

	@Override
	public ArrayList<Persona> readAll() throws ReadAllException {
		return eDao.readAll();
	}

	@Override
	public int dniNoExiste(Persona empleado) throws BuscarException {
		return eDao.dniNoExiste(empleado);
	}

	@Override
	public Persona BuscarEmpleado(String dni) throws BuscarException {
		return eDao.BuscarEmpleado(dni);
	}

	@Override
	public boolean updateMedicosEspecialidad(Medico medico) throws UpdateException {
		return eDao.updateEspecialidadesMedico(medico);
	}
	
	

}
