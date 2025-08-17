package ar.edu.unpaz.serv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unpaz.DTO.DTOCursos;
import ar.edu.unpaz.model.Curso;
import ar.edu.unpaz.repo.IArchivoLectura;

public class ReportesServ implements IReportes{
	IArchivoLectura archivo;
	
	
	// se podria considerar que DTOCursos se pase como argumento??
	public ReportesServ (IArchivoLectura archivo) {
		this.archivo = archivo;
	}
	
	public Curso masCaro() {
		List<Curso> cursos = DTOCursos.get(this.archivo);
		Curso data[] = {cursos.get(0)};
		
		cursos.stream()
		.forEach(c -> {
			if (data[0].calcularPrecioFInal() < c.calcularPrecioFInal())
				data[0] = c;
		});
		
		return data[0];
	};
	
	public void mostrarResumenes() {
		DTOCursos.get(this.archivo)
		.forEach(c -> System.out.println(c.resumen()));
		
	};

	public List<Curso> buscarPorNombreParcial(String nombre_parcial) {
		
		return DTOCursos.get(this.archivo)
				.stream()
				.filter(c -> {
					return c.getNombre().toLowerCase().contains(nombre_parcial.toLowerCase());
				})
				.toList();
	}

	@Override
	public Map<String, List<Curso>> agruparTipos() {
		Map<String, List<Curso>> agrupados = new HashMap<String, List<Curso>>();
		DTOCursos.get(archivo)
			.forEach(c -> {
				agrupados.computeIfAbsent(c.tipo(), k -> new ArrayList<Curso>())
				.add(c);
			});
		
		return agrupados;
	};
//	
//	public void agregarCurso(Curso cursoAGuardar) {};
	
}
