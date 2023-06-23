package excepciones;

import java.io.IOException;

public class UpdateException extends IOException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo modificar el registro de la base de datos";
	}
}
