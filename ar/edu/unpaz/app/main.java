package ar.edu.unpaz.app;

import ar.edu.unpaz.controller.Menu;
import ar.edu.unpaz.repo.Archivo;
import ar.edu.unpaz.serv.CrearCursoServ;
import ar.edu.unpaz.serv.ReportesServ;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Archivo archivo = new Archivo("C:\\Users\\Angel\\OneDrive\\Desktop\\workspace\\workspace poo\\mock.txt");
//		Archivo archivo2 = new Archivo("C:\\Users\\Angel\\OneDrive\\Desktop\\workspace\\workspace poo\\mock2.txt");
		
		ReportesServ reportes = new ReportesServ(archivo);
		CrearCursoServ escritorCursos = new CrearCursoServ(archivo);
		Menu menu = new Menu(reportes,escritorCursos);
		menu.consola();
		
	}
}
