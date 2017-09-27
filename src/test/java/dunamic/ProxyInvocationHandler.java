package dunamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年6月30日下午9:15:37
 */
public class ProxyInvocationHandler implements InvocationHandler{

	private Object rent;
	
	public ProxyInvocationHandler(Object rent){
		this.rent=rent;
	}
	
	/**
	 * 生成代理类对象
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
	}
	
	/**
	 * proxy是代理类
	 * meoth
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		befor(method.getName());
		Object ressult=method.invoke(rent, args);
		after(method.getName());
		return ressult;
	}
	
	public void setRent(Rent rent) {
		this.rent = rent;
	}
	
	
	private void befor(String meothName){
		System.out.println("执行"+meothName+"方法之前");
	}
	
	private void after(String meothName){
		System.out.println("执行"+meothName+"方法之后");
	}
}
