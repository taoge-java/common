package common;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class JdbcTest {

	public static void main(String[] args) throws SQLException {
	    new Thread(new Runnable() {
			public void run() {
				List<SystemLog> list = SystemLog.dao.find("select * from system_log");
				for (Iterator<SystemLog> iterator = list.iterator(); iterator.hasNext();) {
					SystemLog systemLog =  iterator.next();
					System.out.println(systemLog.getInt("id"));
				}
				System.out.println(list);
			}
		}).start();
		
		List<SystemLog> list = SystemLog.dao.find("select * from system_log");
		for (Iterator<SystemLog> iterator = list.iterator(); iterator.hasNext();) {
			SystemLog systemLog =  iterator.next();
			System.err.println(systemLog.getInt("id"));
		}
		System.err.println(list);
	}
	
	@Test
	public void testDel(){
		SystemLog.dao.update("update  system_log set oper_name=? where id=?","taoge",4);
//		List<SystemLog> list = SystemLog.dao.find("select * from system_log");
//		System.err.println(list);
	}
}
