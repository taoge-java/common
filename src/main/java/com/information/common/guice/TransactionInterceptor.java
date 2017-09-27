/**
 * 
 */
package com.information.common.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午2:52:43
 */
public class TransactionInterceptor implements MethodInterceptor {
	
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String name = invocation.getMethod().getName();
        long startTime = System.nanoTime();
        System.out.println(String.format("before method[%s] at %s", name, startTime));

        Object obj = null;
        try {
            obj = invocation.proceed();// 运行服务
        } finally {
            long endTime = System.nanoTime();
            System.out.println(String.format("after method[%s] at %s, cost(ns):%d", name, endTime, (endTime - startTime)));
        }
        return obj;
	}

}
