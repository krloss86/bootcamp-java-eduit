package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.MarcasDao;
import ar.com.educacionit.domain.Marcas;

public class MarcasDaoMysqlImpl extends JDBCBaseDao<Marcas> implements MarcasDao {

	public MarcasDaoMysqlImpl() {
		super("marcas");
	}
	
	public Marcas fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idMarcas = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Long habilitada = rs.getLong("habilitada");
		return new Marcas(idMarcas, descripcion, habilitada);
	}

	@Override
	public String getSaveSQL() {
		return "(DESCRIPCION, HABILITADA) VALUES (?,?)";
	}

	@Override
	public void saveData(Marcas entity, PreparedStatement pst) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL(Marcas entity) {
		return "DESCRIPCION=?, HABILITADA=?";
	}

	@Override
	public void updateData(Marcas entity, PreparedStatement pst) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}

}
