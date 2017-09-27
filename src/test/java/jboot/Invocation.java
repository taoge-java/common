package jboot;

import java.lang.reflect.Method;

import com.test.Man;

import net.sf.cglib.proxy.MethodProxy;

public class Invocation {
	
	private Object object=null;
	
	@SuppressWarnings("unchecked")
	public <T> T getObject() {
		return (T) object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	static InterceptorManger manger=new InterceptorManger();
	
	private Method method;
	
	private Man controller = new Man();
	
	private Object[] args;
	
	private MethodProxy proxy;
	
	private Object target;
	
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public Invocation(Method method, Object[] args, MethodProxy proxy, Object target) {
		this.method = method;
		this.args = args;
		this.proxy = proxy;
		this.target = target;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public MethodProxy getProxy() {
		return proxy;
	}

	public void setProxy(MethodProxy proxy) {
		this.proxy = proxy;
	}

	public void invoke(){
		System.out.println("执行目标方法");
		try {
			object=proxy.invokeSuper(target, args);
			manger.start(this);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
