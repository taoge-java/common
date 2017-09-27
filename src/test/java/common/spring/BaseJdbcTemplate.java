package common.spring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jfinal.jdbc.util.JdbcUtil;

public class BaseJdbcTemplate {
	
	private ModelBuilder modelBuilder = ModelBuilder.me();
	
	static final Object[] NULL_PARA_ARRAY = new Object[0];
	
	public <T> List<T> findAll(String sql,Class<T> cla,Object...  paras){
		Connection connection = JdbcUtil.getConnection();
		return find(connection, sql, cla, paras); 
	}
	
	public <T> List<T> findAll(String sql,Class<T> cla){
		Connection connection = JdbcUtil.getConnection();
		return find(connection, sql,cla); 
	}
	
	private  <T> List<T> find(Connection connection, String sql,Class<T> cla) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		    List<T> modelList = modelBuilder.builderModelList(resultSet,cla);
			connection.close();
			return modelList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public  <T> List<T> findOne(String sql,Class<T> cla,Object... paras){
		Connection connection = JdbcUtil.getConnection();
		return find(connection, sql, cla, paras); 
	}
	
	private <T> List<T> find(Connection connection, String sql,Class<T> cla,Object... paras) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			modelBuilder.fillStatement(preparedStatement,sql,paras);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<T> modelList = modelBuilder.builderModelList(resultSet,cla);
			connection.close();
			return modelList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(String sql){
		Connection connection = JdbcUtil.getConnection();
		return update(connection, sql, NULL_PARA_ARRAY);
	}
	
	public int update(String sql,Object... paras){
		Connection connection = JdbcUtil.getConnection();
		return update(connection, sql, paras);
	}
	
	private int update(Connection connection,String sql,Object... paras){
		return 0;
	}
	
}