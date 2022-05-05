package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoImpl implements ArticuloDao {

	private Connection con;
	
	public ArticuloDaoImpl() {
		try {
			this.con = AdministradorDeConexiones.obtenerConexion();
		} catch (GenericException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}
	
	@Override
	public Articulo save(Articulo Articulo) {// ctrl+f
		
		return Articulo;
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
		//Connection
		
		//Statement
		try (Statement st = this.con.createStatement()) {
			
			//execute del sql
			//ResultSet
			System.out.println("SELECT * FROM ARTICULOS WHERE ID = " + id);
			try(ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID = " + id)) { 
				Articulo articulo = null;
				if(rs.next()) {
					//convertir el ResultSet a Articulo
					//extraer los datos que vienen en el rs
					Long idArticulo = rs.getLong("id");
					String titulo = rs.getString("titulo");
					String codigo = rs.getString("codigo");
					Date fechaCreacion = rs.getDate("fecha_creacion");
					Double precio = rs.getDouble("precio");
					Long stock = rs.getLong("stock");
					Long marcasId = rs.getLong("marcas_id");
					Long categoriasId = rs.getLong("categorias_id");
					
					articulo = new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
				}
				return articulo;
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id:"+id, e);
		}
	}

	@Override
	public Articulo update(Articulo ArticuloToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
