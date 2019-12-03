package cn.sp.rabbitmqdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer
{
    private final static String QUEUE_NAME = "test_1"; // 队列名
    public static void main(final String[] args) throws Exception
    {
    	try ( // 调用工具类创建连接
    	      final Connection connection = ConnectionUntil.getConnection();
    	      // 创建通道(通道包括生产通道和消费通道)
    	      final Channel channel = connection.createChannel();){

            // 声明通道的消息队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 创建待发送的消息
            final String message = "Hello World";
            // 发布消息到队列
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent'" + message + "'");

    	}

    }

}
