package dao;

import java.util.ArrayList;

import entidad.Medico;

public interface MedicoDao {

	public boolean insert(Medico medico);
	public boolean insertMedicoXEspecilidad(Medico medico);
	public boolean delete(int dni);
	public boolean update(Medico medico);
	public ArrayList<Medico> readAll();
}
