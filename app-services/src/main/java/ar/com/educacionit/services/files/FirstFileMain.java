package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FirstFileMain {

	public static void main(String[] args) throws IOException {
		//crear un un objeto de la clase File
		
		File archivo = new File("c:/desarrollo/text.txt");

		boolean exists = archivo.exists();
		
		if(!exists) {
			archivo.createNewFile();
		}
		
		exists = archivo.exists();
		System.out.println(exists);
	}

}
