/**
 * 
 */
package com.information.common.guice;

import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.ImplementedBy;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午3:11:20
 */
@ImplementedBy(BeforeServiceImpl.class)
public interface BeforeService {
	 void before(MethodInvocation invocation);
}
