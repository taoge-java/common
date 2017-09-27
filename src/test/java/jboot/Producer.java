package jboot;

import net.sf.cglib.proxy.Enhancer;

public class Producer {
	
	@SuppressWarnings("rawtypes")
	public static Object create(Class targetClass){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setCallback(new CallBack());
		return  enhancer.create();
	}
	
	@SuppressWarnings("rawtypes")
	public static Object create(String classKey,Class targetClass){
		return targetClass;
	}
}
