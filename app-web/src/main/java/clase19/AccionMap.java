package clase19;

import java.util.HashMap;
import java.util.Map;

public class AccionMap {

	static Map<Integer,IAccion> mapAcciones = construirAcciones();
	
	private static Map<Integer, IAccion> construirAcciones() {
		Map<Integer, IAccion> mapAcciones = new HashMap<Integer, IAccion>();
		//cargo el mapa con las opciones
		mapAcciones.put(1, new AccionAlta());
		mapAcciones.put(2, new AccionBaja());
		mapAcciones.put(3, new AccionModificacion());
		return mapAcciones;
	}

	public static IAccion getAccion(Integer op) {
		
		IAccion accion = new AccionDefault();
		
		if(mapAcciones.containsKey(op)) {
			accion = mapAcciones.get(op);
		}
		
		return accion;
	}
	
}
