/**
 * 
 */
package guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.information.common.guice.AfterMethodIntercepter;

/**
 * @author taoge
 * @version 1.0
 * @create_at 2017年9月9日下午4:43:00
 */
public class Client {

	@Inject
	private Hello hello;
	//创建一个测试程序  
    public static void main(String[] args) {  
         
//        Injector in = Guice.createInjector(new Module(){  
//            public void configure(Binder arg0) {  
//                //什么也不写  
//            }  
//        }) ;  
//        //得到HelloCaller的实例  
//        HelloCaller helloCaller = in.getInstance(HelloCaller.class) ;  
//        //调用sayHello方法  
//        helloCaller.sayHello() ;  
    	Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
            	System.err.println("Guice");
                AfterMethodIntercepter after = new AfterMethodIntercepter();
                binder.requestInjection(after);
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), after);
            }
        });
        injector.getInstance(Client.class).hello.sayHello();
    }  
}
