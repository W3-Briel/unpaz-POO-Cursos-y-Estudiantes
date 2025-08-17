package ar.edu.unpaz.errors;

@SuppressWarnings("serial")
public class EmailInvalidadoException extends Exception{

	public EmailInvalidadoException() {
		super("EmailInvalidadoException: no se cumple con un formato correcto de correo electronico");
	}
}
