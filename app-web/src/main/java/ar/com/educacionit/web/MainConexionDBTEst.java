package ar.com.educacionit.web;

import ar.com.educacionit.daos.OrdenDao;
import ar.com.educacionit.daos.impl.OrdenDaoImpl;
import ar.com.educacionit.domain.Orden;

public class MainConexionDBTEst {

	public static void main(String[] args) {
		
		//dao > impl
		OrdenDao dao = new OrdenDaoImpl();
		
		//crear la orden
		Orden o = new Orden(1l,"test",150f);
		
		dao.create(o);
	}
}
