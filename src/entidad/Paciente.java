package entidad;

import java.util.Date;

public class Paciente {

	private int Dni;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private int CodNacionalidad;
	private Date FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private int Provincia;
	private String Email;
	private String Telefono;
	private boolean Estado;
	
	
	
	public Paciente() {
		
	}
	
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public int getCodNacionalidad() {
		return CodNacionalidad;
	}
	public void setCodNacionalidad(int codNacionalidad) {
		CodNacionalidad = codNacionalidad;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public int getProvincia() {
		return Provincia;
	}
	public void setProvincia(int provincia) {
		Provincia = provincia;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public boolean getEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Paciente [Dni=" + Dni + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
				+ ", CodNacionalidad=" + CodNacionalidad + ", FechaNacimiento=" + FechaNacimiento + ", Direccion="
				+ Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia + ", Email=" + Email
				+ ", Telefono=" + Telefono + ", Estado=" + Estado + "]";
	}
	
	
	
}
