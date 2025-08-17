package ar.edu.unpaz.repo;

import java.io.FileWriter;	
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivo implements IArchivoLectura, IArchivoEscritura{
	private String file;
	
	public Archivo(String url) {
		this.file = url;
	};	
	
	@Override
	public List<String> leer() {
		List<String> data = new ArrayList<String>();
		Path filePath = Paths.get(this.file);
		try {
			Files.lines(filePath)
				.forEach(l -> data.add(l));

			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void escribir(String data) {
		FileWriter escritor = null;
		PrintWriter editor = null;
		
		try {
			escritor = new FileWriter(this.file,true);
			editor = new PrintWriter(escritor);
			
			editor.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			editor.close();
		}
		
	}

}
