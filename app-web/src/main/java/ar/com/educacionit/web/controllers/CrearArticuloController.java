package ar.com.educacionit.web.controllers;

import java.util.Scanner;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class CrearArticuloController {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese los datos del articulo");
		
		//leer los datos del articulo
		System.out.println("Precio:");
		Double precio = teclado.nextDouble();
		
		System.out.println("Titulo:");
		String titulo = teclado.next();
		
		System.out.println("Codigo:");
		String codigo = teclado.next();
		
		System.out.println("Stock:");
		Long stock = teclado.nextLong();
		
		System.out.println("Categoria:");
		Long categoriaId = teclado.nextLong();
		
		System.out.println("Marca:");
		Long marcasId = teclado.nextLong();
		
		//verificar si existen marca y cateoria
		//TPH, implementar dao y service para cateogoria
		
		teclado.close();
		
		Articulo nuevo = new Articulo(titulo, codigo, null, precio, stock, marcasId, categoriaId);
		
		//insertarlo en la db??
		
		ArticulosService articuloService = new ArticulosServiceImpl();

		try {
			
			//obtengo marcasId y categoriasId
			
			articuloService.create(nuevo);
		} catch (ServiceException e) {
			System.err.println(e.getMessage() + "," + e.getCause().getMessage());
			
			System.out.println("Existe, actualizando...");
			//si fue duplicado
			try {
				Articulo artQueExisteEnlaDB = articuloService.getByCodigo(nuevo.getCodigo());
				
				//actualizo los datos de artQueExisteEnlaDB con los de nuevo
				artQueExisteEnlaDB.setCategoriasId(nuevo.getCategoriasId());
				artQueExisteEnlaDB.setMarcasId(nuevo.getMarcasId());
				artQueExisteEnlaDB.setPrecio(nuevo.getPrecio());
				artQueExisteEnlaDB.setCategoriasId(nuevo.getCategoriasId());
				artQueExisteEnlaDB.setStock(artQueExisteEnlaDB.getStock() + nuevo.getStock());
				artQueExisteEnlaDB.setTitulo(nuevo.getTitulo());
				
				articuloService.update(artQueExisteEnlaDB);
			} catch (ServiceException e1) {
				System.err.println(e1.getMessage() + "," + e.getCause());	
			}
			
		}
	}

}
