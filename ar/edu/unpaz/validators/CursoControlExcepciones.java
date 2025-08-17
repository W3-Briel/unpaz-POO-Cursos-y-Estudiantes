package ar.edu.unpaz.validators;

import ar.edu.unpaz.errors.ValorInvalidoException;

public class CursoControlExcepciones {
	
	public static Integer validarValor(String campoName, Integer valor) throws ValorInvalidoException {
		if (!(valor > 0)) throw new ValorInvalidoException(campoName);
		
		return valor;
	}
	
	public static Double validarValor(String campoName, Double valor) throws ValorInvalidoException {
		if (!(valor > 0)) throw new ValorInvalidoException(campoName);
		
		return valor;
	}
	
}
