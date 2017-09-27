/**
 * 
 */
package guice;

import com.google.inject.ImplementedBy;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月9日下午4:41:32
 */
@ImplementedBy(HelloImpl.class)
public interface Hello {
	  void sayHello() ;  
}
