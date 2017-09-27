/**
 * 
 */
package com.information.common.guice;


import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午2:57:50
 */
public class AopTest {

    @Inject
    private Service service;

    public static void main(String[] args) {
	   Injector injector = Guice.createInjector(new Module() {
           @SuppressWarnings({ "rawtypes", "unchecked" })
		public void configure(Binder binder) {
               binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), new TransactionInterceptor());
               Class<?>[] classes = ServiceImpl.class.getInterfaces();
               System.out.println(classes);
               System.out.println(ServiceImpl.class);
               for(Class c: classes){
            	   binder.bind(c).to(ServiceImpl.class);
               }
           }
       });
      // injector.getInstance(AopTest.class).service.sayHello();;
    }
}
