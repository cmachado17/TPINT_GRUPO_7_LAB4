package negocioImpl;

import java.util.ArrayList;

import dao.DiaSemanaDao;
import daoImpl.DiaSemanaDaoImpl;
import entidad.DiaSemana;
import negocio.DiaSemanaNegocio;

public class DiaSemanaNegocioImpl implements DiaSemanaNegocio{
	
	DiaSemanaDao dDao = new DiaSemanaDaoImpl();

	@Override
	public ArrayList<DiaSemana> obtenerDiaSemana() {
		return dDao.obtenerDiaSemana();
	}

}
