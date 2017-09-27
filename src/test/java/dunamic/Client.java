package dunamic;

import java.util.ArrayList;
import java.util.List;

public class Client {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		Rent host=new Host();
		ProxyInvocationHandler proxy=new ProxyInvocationHandler(host);
		Rent rent=(Rent) proxy.getProxy();
		rent.rent();
	}
}
