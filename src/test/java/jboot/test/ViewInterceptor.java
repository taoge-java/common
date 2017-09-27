package jboot.test;

import com.jboot.aop.Interceptor;
import com.jboot.aop.InterceptorManger;
import com.jboot.aop.Invocation;

public class ViewInterceptor implements Interceptor{

	static{
		InterceptorManger.interceptors.add(new ViewInterceptor());
	}
	@Override
	public void invoke(Invocation inv) {
		System.out.println("执行ViewInterceptor");
	}

}
