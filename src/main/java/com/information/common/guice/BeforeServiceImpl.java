/**
 * 
 */
package com.information.common.guice;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午3:11:48
 */
public class BeforeServiceImpl implements BeforeService{

	/* (non-Javadoc)
	 * @see com.information.common.guice.BeforeService#before(org.aopalliance.intercept.MethodInvocation)
	 */
	public void before(MethodInvocation invocation) {
		System.out.println("Before--->" + invocation.getClass().getName());
	}

}
