package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	public ArticuloDaoMysqlImpl() {
		super("articulos");
	}
	
	@Override
	public void save(Articulo articulo) throws DuplicatedException, GenericException {
		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			
			StringBuffer sql = new StringBuffer("INSERT INTO ARTICULOS (TITULO,CODIGO, PRECIO, CATEGORIAS_ID, MARCAS_ID,FECHA_CREACION,STOCK) VALUES(");
			sql.append("?,?,?,?,?,?,?)");
			
			try(PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				st.setString(1, articulo.getTitulo());
				st.setString(2, articulo.getCodigo());
				st.setDouble(3, articulo.getPrecio());
				st.setLong(4, articulo.getCategoriasId());
				st.setLong(5, articulo.getMarcasId());
				st.setDate(6, new java.sql.Date(System.currentTimeMillis()));//java.sql.Date
				st.setLong(7, articulo.getStock());
									
				st.execute();
				
				try(ResultSet rs = st.getGeneratedKeys()){
					
					if(rs.next()) {
						
						Long id = rs.getLong(1);
						
						articulo.setId(id);
					}
				}
			}			
		}catch(SQLException se) {
			if(se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el articulo, integridad de datos violada",se);
			}
			throw new GenericException(se.getMessage(), se);
		}catch(GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}
	}

	@Override
	public Articulo getByCode(String codigo) throws GenericException {
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			String sql = "SELECT * FROM ARTICULOS WHERE codigo = ?";
			
			try (PreparedStatement st = con2.prepareStatement(sql)) {
				
				st.setString(1, codigo);
				
				try(ResultSet rs = st.executeQuery()) { 
					Articulo articulo = null;
					if(rs.next()) {
						articulo = fromResultSetToEntity(rs);
					}
					return articulo;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el articulo id:"+codigo, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id:"+codigo, e);
		}
	}

	@Override
	public void update(Articulo articuloToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE ARTICULOS SET ");
		if(articuloToUpdate.getTitulo() != null) {
			sql.append("titulo=?").append(", ");
		}
		if(articuloToUpdate.getCodigo() != null) {
			sql.append("codigo=?").append(", ");
		}
		if(articuloToUpdate.getPrecio() != null) {
			sql.append("precio=?").append(", ");
		}
		if(articuloToUpdate.getStock() != null) {
			sql.append("stock=?").append(", ");
		}
		if(articuloToUpdate.getMarcasId() != null) {
			sql.append("marcas_id=?").append(", ");
		}
		if(articuloToUpdate.getCategoriasId() != null) {
			sql.append("categorias_id=?").append(",");
		}
		
		sql = new StringBuffer(sql.substring(0, sql.length()-1));
		
		sql.append(" where id=?");
		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			
			try(PreparedStatement st = con2.prepareStatement(sql.toString())) {
				
				//puedo setear atributo=valor con el tipo correcto
				
				if(articuloToUpdate.getTitulo() != null) {
					st.setString(1, articuloToUpdate.getTitulo());
				}
				if(articuloToUpdate.getCodigo() != null) {
					st.setString(2, articuloToUpdate.getCodigo());
				}
				if(articuloToUpdate.getPrecio() != null) {
					st.setDouble(3, articuloToUpdate.getPrecio());
				}
				if(articuloToUpdate.getStock() != null) {
					st.setLong(4, articuloToUpdate.getStock());
				}
				if(articuloToUpdate.getMarcasId() != null) {
					st.setLong(5, articuloToUpdate.getMarcasId());
				}
				if(articuloToUpdate.getCategoriasId() != null) {
					st.setLong(6, articuloToUpdate.getCategoriasId());	
				}
				
				st.setLong(7, articuloToUpdate.getId());
				
				st.execute();//alt+shift+m
			}			
		}catch(GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}catch(SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}
	
	public Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idArticulo = rs.getLong("id");
		String titulo = rs.getString("titulo");
		String codigo = rs.getString("codigo");
		Date fechaCreacion = rs.getDate("fecha_creacion");
		Double precio = rs.getDouble("precio");
		Long stock = rs.getLong("stock");
		Long marcasId = rs.getLong("marcas_id");
		Long categoriasId = rs.getLong("categorias_id");
		return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
	}

}
