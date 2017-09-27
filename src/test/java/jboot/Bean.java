package jboot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Bean {

	//线程安全
	public static final Map<String,Object> map=new ConcurrentHashMap<String,Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> targetClass){
		return (T) Producer.create(targetClass);
	}

	@SuppressWarnings("unchecked")
	public static <T>T getInstance(String className, Class<T> targetClass) {
		Object object=map.get(className);
		if(object == null){
			object = Producer.create(targetClass);
			map.put(className, object);
		}
		return (T) object;
	}
}
