package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain2 {

	public static void main(String[] args) throws IOException {
		//crear un un objeto de la clase File
		
		String fileName = "placa_bienvenidos.png1";
		
		File archivo = new File("c:/desarrollo");
		
		if(archivo.exists()) {			
			File placa = buscarFile(archivo, fileName);
			if(placa != null) {
				System.out.println("Se ha encontrado el archivo " + fileName + " en la carpta :" + placa.getPath());
			}else {
				System.out.println("NO se ha encontrado el archivo " + fileName);
			}
		}
	}
	
	/*
	 * buscar el archivo: placa_bienvenidos.png dentro de el directorio: c:/desarrollo
	 * y sus subcarpetas.
	 * 
	 * Si se encuentra mostrar que carpeta lo contiene, de lo contrario informar que
	 * no existe.
	 * */

	public static File buscarFile(File file, String fileName) {
		
		//caso base?
		if(file.isDirectory() && file.list().length > 0) {
			System.out.println("Carpeta:" + file.getName());
			File aux = null;
			File[] filesInFile = file.listFiles();
			
			for(int i=0;i< filesInFile.length && aux == null;i++) {
				File aFile = filesInFile[i];
				aux = buscarFile(aFile, fileName);	
			}
			
			return aux;
		}else {
			File aux = null;
			System.out.println("Archivo:" + file.getName());
			if(file.getName().equalsIgnoreCase(fileName)) {
				aux = file;
			}
			return aux;			
		}

	}
}
