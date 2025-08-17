package ar.edu.unpaz.model;

public class CursoEnVivo extends Curso{
	private Integer cantidadClases;
	
	public CursoEnVivo(String nombre, Integer horas, Double precio_base, Integer cantidadClases) {
		super(nombre, horas, precio_base);
		// TODO Auto-generated constructor stub
		this.cantidadClases = cantidadClases;
	}

	@Override
	public Double calcularPrecioFInal() {
		return super.precioBase + (100 * this.cantidadClases);
	}

	@Override
	public String resumen() {
		return String.format("clase_nombre; %s horas; %s precioFinal; %s tipo; EnVivo",
				this.nombre,this.horas,this.calcularPrecioFInal());
	}

	@Override
	public String tipo() {
		return "envivo";
	}

	@Override// String nombre, Integer horas, Double precio_base, Integer cantidadClases
	public String toCsv() {
		return String.format("ENVIVO;%s;%s;%s;%s",this.nombre,this.horas,this.precioBase,this.cantidadClases);
	}

	
}
