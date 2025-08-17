package ar.edu.unpaz.model;

import ar.edu.unpaz.errors.ValorInvalidoException;
import ar.edu.unpaz.validators.CursoControlExcepciones;

public abstract class Curso {
	protected String nombre;
	protected Integer horas;
	protected Double precioBase;
	
	public Curso(String nombre, Integer horas, Double precio_base) {
		this.nombre = nombre;
		
		try {
			this.horas = CursoControlExcepciones.validarValor("horas", horas);
			this.precioBase = CursoControlExcepciones.validarValor("precio base", precio_base);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public abstract Double calcularPrecioFInal();
	public abstract String resumen();
	public abstract String tipo();
	public abstract String toCsv();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	
}
