/**
 * 
 */
package guice;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.information.common.util.ClassScanner;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月16日上午11:21:11
 */
public class Test {

	
	@org.junit.Test
	public void test() {
		Injector injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
	            binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Autowired.class), new TxInterceptor());
	            bindBean(binder);
	        }
	    });
		JobManger jobManger = new JobManger();
		injector.injectMembers(jobManger);
		jobManger.print();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void bindBean(Binder binder){
		List<Class> list = ClassScanner.scanClassByAnnotation(Service.class, false);
		for(Class c : list){
			Class<?>[] classes = c.getInterfaces();
			for(Class cla : classes){
				if (cla == Serializable.class) {
                    continue;
                }
				try {
					binder.bind(cla).to(c);
				} catch (Exception e) {
					
				}
			}
		}
	}
}
