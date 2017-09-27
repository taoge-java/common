package jboot;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截管理器
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年7月23日下午12:15:53
 */
public class InterceptorManger {

	public static List<Interceptor> interceptors=new ArrayList<Interceptor>();
	
	public void  start(Invocation inv){
		for(Interceptor interceptor:interceptors){
			interceptor.invoke(inv);
		}
	}
}
