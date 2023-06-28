package negocioImpl;

import java.util.ArrayList;

import dao.TurnosDao;
import daoImpl.TurnoDaoImpl;
import entidad.Turno;
import excepciones.ReadAllException;
import excepciones.UpdateException;
import negocio.TurnoNegocio;

public class TurnoNegocioImpl implements TurnoNegocio {
	
	TurnosDao turDao = new TurnoDaoImpl();

	@Override
	public ArrayList<Turno> turnosMedico(String dni) throws ReadAllException {
		return turDao.turnosMedico(dni);
	}

	@Override
	public boolean update(Turno turno) throws UpdateException {
		return turDao.update(turno);
	}

	@Override
	public ArrayList<Turno> turnosAsignadosPorMedico(String dni) throws ReadAllException {
		return turDao.turnosAsignadosPorMedico(dni);
	}

	@Override
	public ArrayList<Turno> readAll() throws ReadAllException {
		return turDao.readAll();
	}

	@Override
	public boolean updatePorMedico(Turno turno) throws UpdateException {
		return turDao.updatePorMedico(turno);
	}

	@Override
	public Turno buscarTurno(String paciente, String medico, String hora, String dia) {
		return turDao.buscarTurno(paciente,medico,hora,dia);
	}
	
	@Override
	public boolean liberarTurnos(int dni) {
		return turDao.liberarTurnos(dni);
	}

	@Override
	public boolean anularTurnos(int dni, String fechaInicio, String fechaFin) {
		return turDao.anularTurnos(dni, fechaInicio, fechaFin);
	}

	@Override
	public String minDiaTurno() {
		return turDao.minDiaTurno();
	}

	@Override
	public String maxDiaTurno() {
		return turDao.maxDiaTurno();
	}
}
