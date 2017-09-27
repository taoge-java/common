

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;



public class Producer {

	private static final String url="tcp://localhost:61616";
	
	private static final String queueName="queueTest";
	
	public static void main(String[] args) {
//		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
//		Connection connection=null;
//		try {
//		    connection =connectionFactory.createConnection();
//			
//			connection.start();
//			//创建会话
//			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			
//			//创建目的地
//			Queue queue= session.createQueue(queueName);
//			
//            MessageProducer producer=session.createProducer(queue);
//            
//            for(int i=0;i<100;i++){
//            	TextMessage text=session.createTextMessage("text"+i);
//            	producer.send(text);
//            	System.out.println("发送消息:"+text.getText());
//            }
//			
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				connection.close();
//			} catch (JMSException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
