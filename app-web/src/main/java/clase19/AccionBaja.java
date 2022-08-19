package clase19;

import clase7.Articulo;

public class AccionBaja implements IAccion {
	
	@Override
	public void exec(Articulo ctx) {
		
		//dar de baja por id
		InMemoryDB.delete(ctx.getId());
		
		System.out.println("Se ha elminado el articulo de id:" + ctx.getId());
	}

}
