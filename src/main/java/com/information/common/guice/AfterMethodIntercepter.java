/**
 * 
 */
package com.information.common.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午3:12:20
 */
public class AfterMethodIntercepter implements MethodInterceptor{
	
	@Inject
    private BeforeService beforeService;

	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.err.println("invoke");
		beforeService.before(invocation);
        Object obj = null;
        try {
            obj = invocation.proceed();
        } finally {
            System.out.println("after--->" + invocation.getClass().getName());
        }
        return obj;
	}

}
