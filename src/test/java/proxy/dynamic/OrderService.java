package proxy.dynamic;
/**
 * 代理服务接口
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年6月30日下午1:56:31
 */
public interface OrderService {

	public boolean placeOrder(String...goods);  
}
