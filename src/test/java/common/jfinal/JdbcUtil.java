package common.jfinal;

import java.sql.Connection;
import java.sql.SQLException;

import com.jfinal.jdbc.plugin.C3p0Plugin;



public class JdbcUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/information";
	private static final String USER = "root";
	private static final String PASS = "123456";
	
	public static Connection getConnection(){
		try {
			C3p0Plugin c3p0=new C3p0Plugin(URL, USER, PASS);
			return c3p0.getDataSource().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void close(){
		try {
			getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
