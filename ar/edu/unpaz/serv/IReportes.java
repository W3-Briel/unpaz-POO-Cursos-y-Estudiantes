package ar.edu.unpaz.serv;

import java.util.List;
import java.util.Map;

import ar.edu.unpaz.model.Curso;

public interface IReportes {
	public Curso masCaro();
	public void mostrarResumenes();
	public List<Curso> buscarPorNombreParcial(String nombre_parcial);
	public Map<String, List<Curso>> agruparTipos();
}
