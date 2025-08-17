package ar.edu.unpaz.model;

public class CursoGrabado extends Curso{
	private Integer cantidadModulos;
	
	public CursoGrabado(String nombre, Integer horas, Double precio_base, Integer cantidadModulos) {
		super(nombre, horas, precio_base);
		this.cantidadModulos = cantidadModulos;
	}

	@Override
	public Double calcularPrecioFInal() {
		return super.precioBase + (50 * this.cantidadModulos);
	}

	@Override
	public String resumen() {
		return String.format("clase_nombre; %s horas; %s precioFinal; %s tipo; Grabado",
				this.nombre,this.horas,this.calcularPrecioFInal());
	}

	@Override
	public String tipo() {
		// TODO Auto-generated method stub
		return "grabado";
	}

	@Override
	public String toCsv() {
		return String.format("GRABADO;%s;%s;%s;%s", this.nombre,this.horas,this.precioBase,this.cantidadModulos);
	}

}
