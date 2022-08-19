package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SociosDaoMysqlImpl extends JDBCBaseDao<Socios> implements SociosDao {

	public SociosDaoMysqlImpl() {
		super("socios");
	}
	
	@Override
	public String getSaveSQL() {
		return "(APELLIDO,NOMBRE, CODIGO) VALUES (?,?,?)";
	}

	@Override
	public void saveData(Socios entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getApellido());
		st.setString(2, entity.getNombre());
		st.setString(3, entity.getCodigo());
	}
	
	public Socios fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String apellido = rs.getString("apellido");
		String nombre = rs.getString("nombre");
		String codigo = rs.getString("codigo");
		return new Socios(id,apellido, nombre, codigo);
	}


	@Override
	public void updateData(Socios entity, PreparedStatement st) throws SQLException {
		
	}

	@Override
	public String getUpdateSQL(Socios entity) {
		return "";
	}
}
