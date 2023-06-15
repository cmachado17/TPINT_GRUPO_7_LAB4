package dao;

import java.util.ArrayList;
import entidad.Paciente;


public interface PacienteDao {

	public boolean insert(Paciente paciente);
	public boolean delete(int dni);
	public boolean update(Paciente paciente);
	public ArrayList<Paciente> readAll();
	public int dniNoExiste(Paciente paciente);
	public Paciente BuscarPaciente(String dni);
}
