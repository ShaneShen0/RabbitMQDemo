package cn.sp.rabbitmqdemo;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class ConnectionUntil
{
    private final static String host = "localhost"; // RabbitMQ server 地址
    private final static int port = 5672; // 端口
    private final static String user = "admin"; // 用户名
    private final static String pwd = "942653"; // 密码
    private final static String vHost = "testhost"; // RabbitMQ中Erlang虚拟机名字，可使用默认的虚拟机
    public static Connection getConnection() throws Exception
    {
        // 声明Connection工厂类
        final ConnectionFactory cFactory = new ConnectionFactory();
        // 设置地址
        cFactory.setHost(host);
        // 设置端口
        cFactory.setPort(port);
        // 设置虚拟机，可不设置使用默认
        cFactory.setVirtualHost(vHost);
        // 设置用户名
        cFactory.setUsername(user);
        // 设置密码
        cFactory.setPassword(pwd);
        // 获得连接
        final Connection connection = cFactory.newConnection();
        return connection;
    }
}
