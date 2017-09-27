package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceProxy implements InvocationHandler{
	/** 
     * 委托类对象 
     */ 
	private Object target; 
	
	public Object bind(Object target){  
        this.target = target;  
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);  
        // 将动态生成的代理类对象返回给用户即可  
        return proxy;  
    }  
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("用户权限校验....");  
        // 权限校验完成后，调用委托类中的方法即可  
        return method.invoke(target, args);
	}

}
