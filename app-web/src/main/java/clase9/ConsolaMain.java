package clase9;

public class ConsolaMain {

	public static void main(String[] args) {
		
		Consola consola = new Consola("generica", "china", 2022);
		
		// ¿play?
		// xbox?
		
		PlayStation play = new PlayStation("play", "sony", 2022, "abc12345");
		//play es una consola= si
		//play es una playstation=si
		//play es un object
		
		System.out.println(play instanceof Consola);
		
		Consola play2 = new PlayStation("play", "sony", 2022, "abc12345");
	}

}
