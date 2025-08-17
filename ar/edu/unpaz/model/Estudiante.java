package ar.edu.unpaz.model;

import ar.edu.unpaz.errors.EmailInvalidadoException;
import ar.edu.unpaz.validators.EstudianteControlExcepciones;

public class Estudiante implements IIdentificable{
	private String nombre;
	private String email;
		
	public Estudiante(String nombre, String email) {
		this.nombre = nombre;
		
		try {
			this.email = EstudianteControlExcepciones.validarCorreo(email);
		} catch (EmailInvalidadoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String getIdentificador() {
		return this.email;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
