package proxy.dynamic;

import com.proxy.OrderService;
import com.proxy.OrderServiceImpl;
import com.proxy.OrderServiceStaticProxy;

public class Test {

	public static void main(String[] args) {
		 OrderService orderService = new OrderServiceStaticProxy(new OrderServiceImpl());  
	     orderService.placeOrder("apple");  
	}
}
