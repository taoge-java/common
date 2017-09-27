package jboot;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CallBack implements MethodInterceptor{
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) 
			throws Throwable {
		 Class<?> targetClass=obj.getClass();
		 if (targetClass.getName().indexOf("$$EnhancerByCGLIB") != -1) {
			 targetClass = targetClass.getSuperclass();
		 }
		 Invocation invocation=new Invocation(method, args, proxy, obj);
		 invocation.invoke();
		 return  invocation.getObject();
	}
}
