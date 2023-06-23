package negocioImpl;

import java.util.ArrayList;

import dao.MedicoDao;
import daoImpl.MedicoDaoImpl;
import entidad.Medico;
import excepciones.BuscarException;
import excepciones.DeleteException;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;
import negocio.MedicoNegocio;

public class MedicoNegocioImpl implements MedicoNegocio{

	MedicoDao mDao = new MedicoDaoImpl();
	
	@Override
	public boolean insert(Medico medico) throws InsertException {
		return mDao.insert(medico);
	}

	@Override
	public boolean delete(int dni) throws DeleteException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Medico medico) throws UpdateException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Medico> readAll() throws ReadAllException {
		return mDao.readAll();
	}

	@Override
	public Medico buscarMedico(String dni) throws BuscarException {
		return mDao.buscarMedico(dni);
	}

	@Override
	public ArrayList<Medico> medicosPorEspecialidad(int especialidad) throws ReadAllException {
		return mDao.medicosPorEspecialidad(especialidad);
	}

}
