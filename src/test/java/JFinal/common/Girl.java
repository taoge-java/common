/**
 * 
 */
package JFinal.common;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月9日下午4:17:28
 */
@ConfigurationProperties(prefix="girl")
public class Girl {
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
