package entidad;

import java.sql.Date;
import java.sql.Time;

public class Turno {

	private Medico medico;
	private Date dia;
	private Time horario;
	private Paciente paciente;
	private Especialidad especialidad;
	private EstadoTurno estadoTurno;
	
	public Turno() {

	}
	
	public Turno(Medico medico, Date dia, Time horario, Paciente paciente, Especialidad especialidad,
			EstadoTurno estadoTurno) {
		this.medico = medico;
		this.dia = dia;
		this.horario = horario;
		this.paciente = paciente;
		this.especialidad = especialidad;
		this.estadoTurno = estadoTurno;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
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
	@Override
	public String toString() {
		return "Turno [medico=" + medico + ", dia=" + dia + ", horario=" + horario + ", paciente=" + paciente
				+ ", especialidad=" + especialidad + ", estadoTurno=" + estadoTurno + "]";
	}
	
	
}
