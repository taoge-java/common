package jboot;

/**
 * 动态代理工厂
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午4:32:08
 */
public class AopProxyFactory {

	public static <T> T getBean(Class<T> targetClass){
		return Bean.getInstance(targetClass);
	}

	public static <T> T getBean(String className, Class<T> targetClass){
		System.err.println(targetClass.getSuperclass());  ;
		return Bean.getInstance(className,targetClass);
	}
} 
