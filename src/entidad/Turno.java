package entidad;

import java.sql.Date;
import java.sql.Time;

public class Turno {

	private Medico medico;
	private String dia;
	private String horario;
	private Paciente paciente;
	private Especialidad especialidad;
	private EstadoTurno estadoTurno;
	private boolean estado;
	
	public Turno() {

	}
	
	public Turno(Medico medico, String dia, String horario, Paciente paciente, Especialidad especialidad,
			EstadoTurno estadoTurno, boolean estado) {
		this.medico = medico;
		this.dia = dia;
		this.horario = horario;
		this.paciente = paciente;
		this.especialidad = especialidad;
		this.estadoTurno = estadoTurno;
		this.estado = estado;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public EstadoTurno getEstadoTurno() {
		return estadoTurno;
	}
	public void setEstadoTurno(EstadoTurno estadoTurno) {
		this.estadoTurno = estadoTurno;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Turno [medico=" + medico + ", dia=" + dia + ", horario=" + horario + ", paciente=" + paciente
				+ ", especialidad=" + especialidad + ", estadoTurno=" + estadoTurno + "]";
	}
	
	
}
