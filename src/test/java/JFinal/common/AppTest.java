package JFinal.common;

import com.google.inject.Inject;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@test
public class AppTest  extends TestCase{
    
	private Girl girl;
	
	public void testFactory() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		
		
		
		Properties properties = new Properties();
		properties.getValue();
		properties.getClassValue();
	//	Girl girl = (Girl) properties.map.get("girl");
		System.err.println(girl.getName());
		System.err.println(girl.getAge());
//		BeanFactory factory = new BeanFactory();
//		try {
//			Bean bean = factory.getBean(SpringBean.class);
//			bean.createBean();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
	}
}
