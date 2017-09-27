package common.jfinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelBuilder {

    static ModelBuilder modelBuilder = new ModelBuilder();
	
	public static ModelBuilder me(){
		return modelBuilder;
	}
	
	private ModelBuilder() {}
		
	public  void fillStatement(PreparedStatement preparedStatement, String sql, Object[] paras) throws SQLException{
		for(int i=0;i<paras.length;i++){
			preparedStatement.setObject(i+1,paras[i]);
		}
	}
	
	public String[] getColumnNames(ResultSetMetaData metadate) {
		try {
			 int count = metadate.getColumnCount();
			 String[] columnNames = new String[count];//获取列名
		     for (int i = 0; i < count; i++) {
				columnNames[i] = metadate.getColumnName(i+1);
			 }
		     return columnNames;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> findAll(ResultSet resultSet, String[] columnNames, Class<? extends Model> modelClass) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				 Model<?> model = modelClass.newInstance();
				 Map<String, Object> attr = model.getAttrs();
				 for (int i = 0; i < columnNames.length; i++) {
					try {
						attr.put(columnNames[i], resultSet.getObject(columnNames[i]));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 }
				 list.add((T)model);
			 }
			 return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T findOne(ResultSet resultSet, String[] columnNames, Class<? extends Model> modelClass) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				 Model<?> model = modelClass.newInstance();
				 Map<String, Object> attr = model.getAttrs();
				 for (int i = 0; i < columnNames.length; i++) {
					try {
						attr.put(columnNames[i], resultSet.getObject(columnNames[i]));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					list.add((T)model);
				 }
			 }
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 转换成sql
	 * @param sql
	 * @return
	 */
	public String appendSql(StringBuilder sql) {
		return null;
	}
}
