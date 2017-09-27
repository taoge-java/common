/**
 * 
 */
package guice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Singleton;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月16日上午11:07:26
 */
@Service
@Singleton
public class SqlServerDataSource implements DataSource {

	@Autowired
	public void getDataSource() {
		System.out.println("SqlServerDataSource");
	}

}
