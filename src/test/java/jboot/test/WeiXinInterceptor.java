package jboot.test;

import com.jboot.aop.Interceptor;
import com.jboot.aop.InterceptorManger;
import com.jboot.aop.Invocation;

public class WeiXinInterceptor implements Interceptor{

	static{
		InterceptorManger.interceptors.add(new WeiXinInterceptor());
	}
	@Override
	public void invoke(Invocation inv) {
		System.out.println("WeiXinInterceptor拦截器");
	}

}
