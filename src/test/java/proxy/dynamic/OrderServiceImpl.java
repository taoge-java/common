package proxy.dynamic;
/**
 * 服务的实现类！实际业务处理的类，代理中的委托类。 
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年6月30日下午1:58:38
 */
public class OrderServiceImpl implements OrderService {

	@Override
	public boolean placeOrder(String... goods) {
		 System.out.println("开始下订单， 请等待....");  
	     System.out.println("订单已生效....");  
	     return true;  
	}

}
