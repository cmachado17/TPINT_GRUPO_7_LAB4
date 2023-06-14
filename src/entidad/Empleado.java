package entidad;

public class Empleado {
	private int Dni;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private int CodNacionalidad;
	private String FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private int Provincia;
	private String Email;
	private String Telefono;
	private TipoUsuario TipoUser;
	private String Clave;
	private boolean Estado;
	
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
	public TipoUsuario getTipoUser() {
		return TipoUser;
	}
	public void setTipoUser(TipoUsuario tipoUser) {
		TipoUser = tipoUser;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
}
