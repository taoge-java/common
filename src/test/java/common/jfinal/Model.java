package common.jfinal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.jdbc.util.JdbcUtil;


@SuppressWarnings({ "rawtypes", "serial" })
public abstract  class Model<T extends Model> implements Serializable{
	
	private ModelBuilder modelBuilder = ModelBuilder.me();
	
    static final Object[] NULL_PARA_ARRAY = new Object[0];
    
	private Map<String,Object> attrs = new HashMap<String, Object>();
	
	public  Map<String,Object> getAttrs() {
		return attrs;
	}
	
	public Integer getInt(String key){
		return (Integer) attrs.get(key);
	}
	
	public Boolean getBoolean(String key){
		return (Boolean) attrs.get(key);
	}
	
	public String getStr(String key){
		return (String) attrs.get(key);
	}
	
	public BigDecimal BigDecimal(String key){
		return (java.math.BigDecimal) attrs.get(key);
	}
	
	public Date getDate(String key){
		return (Date) attrs.get(key);
	}
	
	public List<T> find(String sql){
		Connection connection = JdbcUtil.getConnection();
		return find(connection,sql,NULL_PARA_ARRAY); 
	}
	
	public List<T> find(String sql,Object... paras){
		Connection connection = JdbcUtil.getConnection();
		return find(connection,sql,paras); 
	}
	
	public T findOne(String sql){
		List<T> result = (List<T>) find(sql);
		return result.size()> 0 ? result.get(0) : null;
	}
	
	public  T findOne(String sql,Object... paras){
		List<T> result = find(sql,paras);
		return result.size()> 0 ? result.get(0) : null;
	}
	
	private List<T> find(Connection connection,String sql,Object... paras){
		try {
		     PreparedStatement preparedStatement = connection.prepareStatement(sql);
		     ResultSetMetaData metadate=  preparedStatement.getMetaData();
		     String[] columnNames = modelBuilder.getColumnNames(metadate);
		     modelBuilder.fillStatement(preparedStatement,sql,paras);
		     ResultSet resultSet = preparedStatement.executeQuery();
		     List<T> modelList = modelBuilder.findAll(resultSet,columnNames,getClass());
		     connection.close();
             return modelList;
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	public boolean update(String sql){
		Connection connection = JdbcUtil.getConnection();
		return update(connection, sql,NULL_PARA_ARRAY); 
	}
	
	private boolean update(Connection connection, String sql, Object... paras) {
		return execute(connection, sql, paras);
	}

	public boolean update(String sql,Object... paras){
		Connection connection = JdbcUtil.getConnection();
		return update(connection, sql,paras); 
	}
	
	public boolean delete(String sql){
		Connection connection = JdbcUtil.getConnection();
		return execute(connection, sql,NULL_PARA_ARRAY); 
	}
	
	public boolean delete(String sql,Object... paras){
		Connection connection = JdbcUtil.getConnection();
		return execute(connection, sql,paras); 
	}

	private boolean execute(Connection connection, String sql, Object... paras) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			modelBuilder.fillStatement(preparedStatement,sql,paras);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T set(String name,Object value) {
		attrs.put(name, value);
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public T put(String name,Object value) {
		attrs.put(name, value);
		return (T) this;
	}
	
	public void save(){
		Connection connection = JdbcUtil.getConnection();
		StringBuilder sql = new StringBuilder();
	}
}
