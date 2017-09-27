/**
 * 
 */
package guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月16日上午11:08:54
 */
public class TxInterceptor implements MethodInterceptor{
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
        return invocation.proceed();
	}
}
