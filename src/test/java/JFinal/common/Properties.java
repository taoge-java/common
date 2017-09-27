/**
 * 
 */
package JFinal.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.information.common.util.StrKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月9日下午4:13:21
 */
public class Properties {

    private Prop prop = null;
	
    private static final Injector injector = Guice.createInjector();
    
	private static ConcurrentHashMap<String,String> propertiesKey = new ConcurrentHashMap<String,String>();
	
	static Map<String,Object> map = new HashMap<String,Object>();
	
	@SuppressWarnings({ "rawtypes","unchecked" })
	public void getValue() {
		List<Class> cla = ClassScanner.scanClassByAnnotation(ConfigurationProperties.class, false);
		for(Class c : cla){
			try {
				ConfigurationProperties configurationProperties = (ConfigurationProperties) c.getAnnotation(ConfigurationProperties.class);
				getPropertiesValue(configurationProperties);
				Object object = injector.getInstance(c);
				map.put("girl", object);
				Method[] methods = c.getMethods();
				for(Method method : methods){
					if(method.getName().startsWith("set")){
						String key = StrKit.toLowerCaseFirst(method.getName().substring(3));
						propertiesKey.put(key, prop.get(key));
						method.invoke(object, convert(method.getParameterTypes()[0], prop.get(key)));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
	}


	@SuppressWarnings("rawtypes")
	public void getClassValue() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		List<Class> cla = ClassScanner.scanClassByAnnotation(test.class, false);
		for(Class c : cla){
			Field[] field = c.getDeclaredFields();
			for(Field f : field){
				f.setAccessible(true);
				f.set(c.newInstance(), map.get("girl"));
			}
		}
	}
	/**
	 * @param configurationProperties 
	 * 
	 */
	private void getPropertiesValue(ConfigurationProperties configurationProperties) {
        if(StrKit.isNotEmpoty(configurationProperties.prefix())){
			prop = PropKit.use("config.properties");
		}else{
			prop = PropKit.use(configurationProperties.prefix());
		}
	}

	/**
     * 数据转化
     *
     * @param type
     * @param s
     * @return
     */
    private static final Object convert(Class<?> type, String s) {

        if (type == String.class) {
            return s;
        }


        // mysql type: int, integer, tinyint(n) n > 1, smallint, mediumint
        if (type == Integer.class || type == int.class) {
            return Integer.parseInt(s);
        }

        // mysql type: bigint
        if (type == Long.class || type == long.class) {
            return Long.parseLong(s);
        }


        // mysql type: real, double
        if (type == Double.class || type == double.class) {
            return Double.parseDouble(s);
        }

        // mysql type: float
        if (type == Float.class || type == float.class) {
            return Float.parseFloat(s);
        }

        // mysql type: bit, tinyint(1)
        if (type == Boolean.class || type == boolean.class) {
            String value = s.toLowerCase();
            if ("1".equals(value) || "true".equals(value)) {
                return Boolean.TRUE;
            } else if ("0".equals(value) || "false".equals(value)) {
                return Boolean.FALSE;
            } else {
                throw new RuntimeException("Can not parse to boolean type of value: " + s);
            }
        }

        // mysql type: decimal, numeric
        if (type == java.math.BigDecimal.class) {
            return new java.math.BigDecimal(s);
        }

        // mysql type: unsigned bigint
        if (type == java.math.BigInteger.class) {
            return new java.math.BigInteger(s);
        }

        // mysql type: binary, varbinary, tinyblob, blob, mediumblob, longblob. I have not finished the test.
        if (type == byte[].class) {
            return s.getBytes();
        }

        throw new RuntimeException(type.getName() + " can not be converted, please use other type in your config class!");
    }
    
}
