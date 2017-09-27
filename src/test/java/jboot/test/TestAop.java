package jboot.test;

import org.junit.Test;

import com.jboot.aop.AopProxyFactory;

//import org.junit.Test;

public class TestAop {

	public static void main(String[] args) {
		//System.out.println(Man.class.getName());
		Man man = AopProxyFactory.getBean(Man.class.getName(), Man.class);
		man.add();
	}
	
	@Test
	public void testSql(){
		StringBuilder id=new StringBuilder();
		long start=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			id.append(i).append(",");
		}
		System.out.println(id);
		long end=System.currentTimeMillis();
		System.err.println(end-start);
//		Db.query("", 1);
	}
}
