package negocioImpl;

import java.util.ArrayList;

import dao.TurnosDao;
import daoImpl.TurnoDaoImpl;
import entidad.Turno;
import excepciones.ReadAllException;
import negocio.TurnoNegocio;

public class TurnoNegocioImpl implements TurnoNegocio {
	
	TurnosDao turDao = new TurnoDaoImpl();

	@Override
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException {
		return turDao.turnosMedico(dni);
	}

}
