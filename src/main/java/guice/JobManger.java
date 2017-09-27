/**
 * 
 */
package guice;

import com.google.inject.Inject;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月17日下午4:27:37
 */
public class JobManger {

	@Inject
	private DataSource dataSource;
	
	
	public void print(){
		dataSource.getDataSource();
	}
}
