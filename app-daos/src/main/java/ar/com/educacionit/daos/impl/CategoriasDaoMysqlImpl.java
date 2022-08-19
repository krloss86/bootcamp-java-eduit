package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriasDao {

	public CategoriasDaoMysqlImpl() {
		super("categorias");
	}
	
	@Override
	public void save(Categorias Categorias) throws DuplicatedException, GenericException {
		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			
			StringBuffer sql = new StringBuffer("INSERT INTO CategoriasS (TITULO,CODIGO, PRECIO, CATEGORIAS_ID, MARCAS_ID,FECHA_CREACION,STOCK) VALUES(");
			sql.append("?,?,?,?,?,?,?)");
			
			try(PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				st.execute();
				
				try(ResultSet rs = st.getGeneratedKeys()){
					
					if(rs.next()) {
						
						Long id = rs.getLong(1);
						
						Categorias.setId(id);
					}
				}
			}			
		}catch(SQLException se) {
			if(se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el Categorias, integridad de datos violada",se);
			}
			throw new GenericException(se.getMessage(), se);
		}catch(GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}
	}

	@Override
	public void update(Categorias CategoriasToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE CategoriasS SET ");
		
		
		sql.append(" where id=?");
		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			
			try(PreparedStatement st = con2.prepareStatement(sql.toString())) {
				
				//puedo setear atributo=valor con el tipo correcto
				
				
				st.setLong(7, CategoriasToUpdate.getId());
				
				st.execute();//alt+shift+m
			}			
		}catch(GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		}catch(SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}

	public Categorias fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idCategorias = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Long habilitada = rs.getLong("habilitada");
		return new Categorias(idCategorias, descripcion, habilitada);
	}

	@Override
	public String getSaveSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveData(Categorias entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUpdateSQL(Categorias entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateData(Categorias entity, PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
