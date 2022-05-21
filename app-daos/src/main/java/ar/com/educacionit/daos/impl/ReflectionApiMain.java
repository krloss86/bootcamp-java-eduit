package ar.com.educacionit.daos.impl;

import java.lang.reflect.Field;
import java.util.Date;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Orden;

public class ReflectionApiMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Articulo art = new Articulo(1l, "titulo", "codigo", new Date(), 1500D, 1l, 1l, 1l);
		Categorias cat = new Categorias(1L, "desc 112", 1L);
		Orden ord = new Orden(1L, "o32123123", 150F);

		mostrarAtributos(art);
		System.out.println("---");
		mostrarAtributos(cat);
		System.out.println("---");
		mostrarAtributos(ord);
	}

	private static void mostrarAtributos(Object obj) throws IllegalAccessException {
		//¿CÓMO SE QUE ATRIBUTOS TIENE?
		Field[] atrs = obj.getClass().getDeclaredFields();
		
		for(Field f : atrs) {
			f.setAccessible(true);
			System.out.print(f.getName()+ " ");	
			Object valor = f.get(obj);
			System.out.println(valor);
		}
	}

}
