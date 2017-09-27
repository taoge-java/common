/**
 * 
 */
package JFinal.common.factoryModel;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月7日下午1:45:44
 */
public class BeanFactory {

	public Bean getBean(Class<? extends Bean> cla) throws InstantiationException, IllegalAccessException{
		return cla.newInstance();
	}
}
