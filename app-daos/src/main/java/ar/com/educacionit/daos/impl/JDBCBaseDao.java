package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;

public abstract class JDBCBaseDao<T> implements GenericDao<T>{

	protected String tabla;
	
	public JDBCBaseDao(String tabla) {
		if(tabla == null) {
			throw new IllegalArgumentException("Debe indicar la tabla del DAO");
		}
		this.tabla = tabla;
	}
	
	@Override
	public T getByPK(Long id) throws GenericException {
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			try (Statement st = con2.createStatement()) {
				
				String sql = "SELECT * FROM " + this.tabla + " WHERE ID = " + id; 
				
				try(ResultSet rs = st.executeQuery(sql)) { 
					T entity = null;
					if(rs.next()) {
						entity = this.fromResultSetToEntity(rs);
					}
					return entity;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el entity "+this.tabla+"id:"+id, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el entity "+ this.tabla+" id:"+id, e);
		}
	}
	
	@Override
	public List<T> findAll() throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla;
		try(
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql);
			) {
			while(rs.next()) {
				T entity = this.fromResultSetToEntity(rs);
				registros.add(entity);
			}					
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: " +sql, e);
		}
		return registros;
	}
	
	@Override
	public List<T> findPageable(Integer currentPage, Integer size) throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla + "LIMIT "+ size + " offset "+ (currentPage-1);
		try(
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql);
			) {
			while(rs.next()) {
				T entity = this.fromResultSetToEntity(rs);
				registros.add(entity);
			}					
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: " +sql, e);
		}
		return registros;
	}
	
	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM " +this.tabla+ " WHERE ID = " + id;
		try (
				Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
		) {
			st.executeUpdate(sql);
		}catch(GenericException ge) {
			throw new GenericException(sql, ge);
		}catch(SQLException se) {
			throw new GenericException(sql, se);
		}
	}
	
	//cada hijo convierte el ResultSet a la entidad que le corresponde 
	public abstract T fromResultSetToEntity(ResultSet rs) throws SQLException;
		
}
