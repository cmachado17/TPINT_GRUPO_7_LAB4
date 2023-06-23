package negocioImpl;

import java.util.ArrayList;

import dao.EmpleadoDao;
import daoImpl.EmpleadoDaoImpl;
import entidad.Medico;
import entidad.Persona;
import negocio.EmpleadoNegocio;

public class EmpleadoNegocioImpl implements EmpleadoNegocio {

	EmpleadoDao eDao = new EmpleadoDaoImpl();
	
	@Override
	public boolean insert(Persona empleado) {
		return eDao.insert(empleado);
	}

	@Override
	public boolean insertMedicosPorEspecialidad(Medico medico) {
		return eDao.insertMedicosPorEspecialidad(medico);
	}

	@Override
	public boolean delete(int dni) {
		return eDao.delete(dni);
	}

	@Override
	public boolean update(Persona empleado) {
		return eDao.update(empleado);
	}

	@Override
	public ArrayList<Persona> readAll() {
		return eDao.readAll();
	}

	@Override
	public int dniNoExiste(Persona empleado) {
		return eDao.dniNoExiste(empleado);
	}

	@Override
	public Persona BuscarEmpleado(String dni) {
		return eDao.BuscarEmpleado(dni);
	}
	
	

}
