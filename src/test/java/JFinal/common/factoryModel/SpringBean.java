/**
 * 
 */
package JFinal.common.factoryModel;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月7日下午1:43:54
 */
public class SpringBean implements Bean{

	/* (non-Javadoc)
	 * @see JFinal.common.factoryModel.BeanFacytory#createBean()
	 */
	public void createBean() {
		System.out.println("SpringBean");
	}

}
