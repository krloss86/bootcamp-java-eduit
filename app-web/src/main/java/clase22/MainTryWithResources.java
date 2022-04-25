package clase22;

import java.util.Scanner;

public class MainTryWithResources {

	public static void main(String[] args) {
		
		try(Scanner teclado = new Scanner(System.in);) {
			System.out.println(teclado.next());
		}
	}
}
