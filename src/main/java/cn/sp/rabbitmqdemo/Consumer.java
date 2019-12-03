package cn.sp.rabbitmqdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
public class Consumer
{
    private final static String QUEUE_NAME = "test_1";// 队列名，与生产者的目标队列名一致
    static String message;
    public static void main(final String[] args) throws Exception
    {
        final Connection connection = ConnectionUntil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消息递送后的回调函数
        final DeliverCallback deliverCallback = (consumerTag,delivery)->{
             message = new String(delivery.getBody(),"UTF-8");
            System.out.println("[x] Received'" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag ->
        {
        });
    }
}
