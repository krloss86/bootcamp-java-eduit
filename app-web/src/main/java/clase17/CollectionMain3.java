package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionMain3 {

	public static void main(String[] args) {
		
		Collection<String> nombres = new ArrayList<>();
		
		nombres = new LinkedList<>();
		
		//Collection<T>
		//		List<T>
		//			-ArrayList<T>
		//			-LinkedList<T>
		//		Set<T>
		//			-HashSet<T>
		//			-TreeSet<T>
		
		nombres = new HashSet<>();
		
		nombres = new LinkedList<>();
	}

}
