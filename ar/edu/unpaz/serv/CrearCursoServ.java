package ar.edu.unpaz.serv;

import ar.edu.unpaz.model.Curso;
import ar.edu.unpaz.repo.IArchivoEscritura;

public class CrearCursoServ implements IEscribirCurso{
	IArchivoEscritura archivo;
	
	public CrearCursoServ(IArchivoEscritura archivoParaEscribir) {
		this.archivo = archivoParaEscribir;
	}
	
	public void escribirCurso(Curso curso) {
		this.archivo.escribir(curso.toCsv());
	}
}
