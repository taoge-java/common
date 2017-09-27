



public class AppConsumer {

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
//			MessageConsumer messageConsumer = session.createConsumer(queue);
//			
//			//创建监听器
//			messageConsumer.setMessageListener(new MessageListener() {
//				public void onMessage(Message message) {
//					TextMessage textMessage=(TextMessage) message;
//					try {
//						System.out.println("接受消息"+textMessage.getText());
//					} catch (JMSException e) {
//						e.printStackTrace();
//					}
//				}
//			});
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
