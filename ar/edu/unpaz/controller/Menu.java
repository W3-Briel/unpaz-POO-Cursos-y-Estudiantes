package ar.edu.unpaz.controller;

import java.util.Scanner;

import ar.edu.unpaz.DTO.DTOCursos;
import ar.edu.unpaz.model.Curso;
import ar.edu.unpaz.serv.IEscribirCurso;
import ar.edu.unpaz.serv.IReportes;

public class Menu {
	IReportes reportesServ;
	IEscribirCurso escritor;
	
	
	public Menu(IReportes reportes, IEscribirCurso escritor) {
		this.reportesServ = reportes;
		this.escritor = escritor;
	}
	
	public void consola() {
		
		Scanner sc = new Scanner(System.in);
		String menutxt = "menu; \t1) obtener curso mas caro\n\t2) mostrar resumenes\n\t3) buscar curso por nombre parcial\n\t4) agrupar por tipos\n\t5) Escribir cursos";
		String menufootertxt = "\ningresa tu opcion valida, o cualquier otra para salir: ";
		
		Boolean mostrarMenu = true;
		while (mostrarMenu) {
			System.out.println(menutxt + menufootertxt);
			
			char opcion = sc.next().charAt(0);
			
			switch (opcion){
			case '1':
				System.out.println("--- el curso mas caro es: ");
				System.out.println(this.reportesServ.masCaro().resumen());
				break;
			case '2':
				System.out.println("--- resumenes de cursos: ");
				this.reportesServ.mostrarResumenes();
				break;
			case '3':
				System.out.println("ingrese nombre parcial: ");
				String nombreParcial = sc.next();
				System.out.println("--- resumenes de cursos con ese nombre parcial: ");
				
				this.reportesServ.buscarPorNombreParcial(nombreParcial)
					.forEach(c -> System.out.println(c.resumen()));
				break;
			case '4':
				System.out.println("--- agrupados por tipos");
				this.reportesServ.agruparTipos()
					.forEach((k, listaCursos) -> {
						System.out.println("tipo: "+ k + "\n");
						listaCursos.forEach(c -> System.out.println(c.resumen()));
					});
			case '5':
				System.out.println("Ingresar curso con el siguiente formato: ");
				System.out.println("tipoCurso;nombre;horas;precioBase;clasesOModulos");
				
				sc.nextLine();//borramos el enter pendiente
				String csv = sc.nextLine();
				
				Curso curso = DTOCursos.make(csv);
				
				this.escritor.escribirCurso(curso);
				break;
			default:
				mostrarMenu = false;
				System.out.println("\n\n\nchau cuidate");
				System.out.println("\n\n\nchau cuidate");
				sc.close();
			}
		}
		
	}
	
}
