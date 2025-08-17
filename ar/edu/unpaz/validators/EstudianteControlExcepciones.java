package ar.edu.unpaz.validators;

import ar.edu.unpaz.errors.EmailInvalidadoException;

public class EstudianteControlExcepciones {
	
	public static String validarCorreo(String correo) throws EmailInvalidadoException {
		if (!correo.contains("@")) throw new EmailInvalidadoException();
		return correo;
	}
}
