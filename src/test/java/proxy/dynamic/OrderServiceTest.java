package proxy.dynamic;

import com.proxy.OrderService;
import com.proxy.OrderServiceImpl;

public class OrderServiceTest {
	
	 public static void main(String[] args) {  
        OrderService orderService = (OrderService)new OrderServiceProxy().bind(new OrderServiceImpl());  
        orderService.placeOrder("apple");  
	 }  
}
