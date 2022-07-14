package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.MeliSiteDao;
import ar.com.educacionit.domain.Site;

public class MeliSIteDaoMysqlImpl extends JDBCBaseDao<Site> implements MeliSiteDao {

	public MeliSIteDaoMysqlImpl() {
		super("meli_site");
	}
	
	@Override
	public String getSaveSQL() {
		return "(CODIGO,NAME) VALUES (?,?)";
	}

	@Override
	public void saveData(Site entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getCodigo());
		st.setString(2, entity.getName());
	}
	
	public Site fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String codigo = rs.getString("codigo");
		String name = rs.getString("name");
		return new Site(id, codigo, name);
	}


	@Override
	public void updateData(Site entity, PreparedStatement st) throws SQLException {
		int idx = 1;
		if (entity.getName() != null) {
			st.setString(idx++, entity.getName());
		}
	}

	@Override
	public String getUpdateSQL(Site entity) {
		StringBuffer sql = new StringBuffer();
		if (entity.getName() != null) {
			sql.append("name=?").append(", ");
		}
		return sql.substring(0, sql.length() - 1).toString();
	}
}
