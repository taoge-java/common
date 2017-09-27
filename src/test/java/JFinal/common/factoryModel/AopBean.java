/**
 * 
 */
package JFinal.common.factoryModel;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月7日下午1:44:50
 */
public class AopBean implements Bean{

	/* (non-Javadoc)
	 * @see JFinal.common.factoryModel.Bean#createBean()
	 */
	public void createBean() {
		System.out.println("AopBean");
	}

}
