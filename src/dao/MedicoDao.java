package dao;

import java.util.ArrayList;

import entidad.Medico;

public interface MedicoDao {

	public boolean insert(Medico medico);
	public boolean delete(int dni);
	public boolean update(Medico medico);
	public ArrayList<Medico> readAll();
	public Medico buscarMedico(String dni);
	public ArrayList<Medico> medicosPorEspecialidad(int especialidad);
}
