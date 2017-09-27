package jboot;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

	public static void query(String sql,Object...paras){
		C3p0Plugin c3po=new C3p0Plugin("root", "123456", "jdbc:mysql://localhost:3306/furniture?serverTimezone=UTC&characterEncoding=utf8");
		c3po.setDriverClass("com.mysql.cj.jdbc.Driver");
		Connection conn=c3po.getConnection();
		try {
			Statement st=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
	}
}
