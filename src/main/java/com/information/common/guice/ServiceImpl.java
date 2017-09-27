/**
 * 
 */
package com.information.common.guice;

import java.io.Serializable;

import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月11日下午2:57:08
 */
@Singleton
public class ServiceImpl implements Service,Serializable{

	@Named("log")
	public void sayHello() {
		 System.out.println(String.format("[%s#%d] execute %s at %d", this.getClass().getSimpleName(), hashCode(), "sayHello", System.nanoTime()));
	}

}
