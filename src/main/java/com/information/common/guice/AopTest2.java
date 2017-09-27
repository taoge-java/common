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
 * @create_at 2017年9月11日下午3:13:15
 */
public class AopTest2 {

	    @Inject
	    private Service service;

	    public static void main(String[] args) {
	        Injector injector = Guice.createInjector(new Module() {
	            public void configure(Binder binder) {
	                AfterMethodIntercepter after = new AfterMethodIntercepter();
	                binder.requestInjection(after);
	                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), after);
	            }
	        });
	        injector.getInstance(AopTest2.class).service.sayHello();
	    }

}
