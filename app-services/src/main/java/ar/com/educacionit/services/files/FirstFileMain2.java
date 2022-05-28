package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain2 {

	public static void main(String[] args) throws IOException {
		//crear un un objeto de la clase File
		
		File archivo = new File("c:/desarrollo");
		
		boolean isFile = archivo.isFile();
		boolean isDirectory = archivo.isDirectory();
		
		System.out.println(isFile);
		System.out.println(isDirectory);
		
		
		//recursividad!
		
	}

	
}
