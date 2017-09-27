package proxy.dynamic;
/** 
 * 订单服务的静态代理类！ 
 */  
public class OrderServiceStaticProxy implements OrderService {

	private OrderServiceImpl orderService;  
    
    public OrderServiceStaticProxy(OrderServiceImpl orderService) {  
        this.orderService = orderService;  
    }  
  
    @Override  
    public boolean placeOrder(String... goods) {  
        System.out.println("用户权限校验....");  
        System.out.println("订单有效性校验....");  
        return orderService.placeOrder(goods);  
    }  
}
