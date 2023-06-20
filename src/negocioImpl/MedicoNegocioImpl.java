package negocioImpl;

import java.util.ArrayList;

import dao.MedicoDao;
import daoImpl.MedicoDaoImpl;
import entidad.Medico;
import negocio.MedicoNegocio;

public class MedicoNegocioImpl implements MedicoNegocio{

	MedicoDao mDao = new MedicoDaoImpl();
	
	@Override
	public boolean insert(Medico medico) {
		return mDao.insert(medico);
	}

	@Override
	public boolean delete(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Medico> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
