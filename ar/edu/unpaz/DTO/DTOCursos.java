package ar.edu.unpaz.DTO;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unpaz.model.Curso;
import ar.edu.unpaz.model.CursoEnVivo;
import ar.edu.unpaz.model.CursoGrabado;
import ar.edu.unpaz.repo.IArchivoLectura;

public class DTOCursos {

	private DTOCursos() {};
	
	public static List<Curso> get (IArchivoLectura archivo){
		List<Curso> data = new ArrayList<Curso>();
//		// String nombre, Integer horas, Double precio_base, Integer cantidadModulos
		archivo.leer().forEach(l -> {
			data.add(DTOCursos.make(l));
		});
		
		return data;
	}
	
	public static Curso make (String dataCSV) {
		String[] splited = dataCSV.split(";");
		if (splited.length > 5) throw new Error("formato incorrecto - cursos");

		return splited[0]
				.toLowerCase()
				.equals("grabado")
				? new CursoGrabado(splited[1],Integer.parseInt(splited[2]), Double.parseDouble(splited[3]), Integer.parseInt(splited[4])) 
				: new CursoEnVivo(splited[1],Integer.parseInt(splited[2]), Double.parseDouble(splited[3]), Integer.parseInt(splited[4]));
	}
}
