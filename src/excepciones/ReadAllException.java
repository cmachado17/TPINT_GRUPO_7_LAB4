package excepciones;

import java.io.IOException;

public class ReadAllException extends IOException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudieron obtener los listados de la base de datos";
	}
}
