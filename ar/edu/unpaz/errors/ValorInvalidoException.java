package ar.edu.unpaz.errors;

@SuppressWarnings("serial")
public class ValorInvalidoException extends Exception{
	public ValorInvalidoException(String campoName) {
		super(String.format("El valor de este campo %s es invalido!", campoName));
	}
}
