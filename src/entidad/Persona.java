package entidad;

public class Persona {
	private int Dni;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private Nacionalidad CodNacionalidad;		
	private String FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private Provincia Provincia;				
	private String Email;
	private String Telefono;
	private boolean Estado;

	public Persona() {
		
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

	public Nacionalidad getCodNacionalidad() {
		return CodNacionalidad;
	}

	public void setCodNacionalidad(Nacionalidad codNacionalidad) {
		CodNacionalidad = codNacionalidad;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
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

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
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
		return "Persona [Dni=" + Dni + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
				+ ", CodNacionalidad=" + CodNacionalidad + ", FechaNacimiento=" + FechaNacimiento + ", Direccion="
				+ Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia + ", Email=" + Email
				+ ", Telefono=" + Telefono + ", Estado=" + Estado + "]";
	}
	
	
}
