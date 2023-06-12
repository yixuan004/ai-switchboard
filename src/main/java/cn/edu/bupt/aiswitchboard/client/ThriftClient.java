package cn.edu.bupt.aiswitchboard.client;
import cn.edu.bupt.aiswitchboard.thrift.ClassifyService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.stereotype.Component;

@Component
public class ThriftClient {
    private String host;
    private Integer port;  // 端口

    // 单例模式
    public ThriftClient() {
    }

    public ThriftClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void callPythonService(String sceneName, String text) {
        try {
            TTransport transport = new TSocket(host, port);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            ClassifyService.Client client = new ClassifyService.Client(protocol);

            // 调用Python服务的方法
            boolean pingResult = client.ping();
            System.out.println("Ping result: " + pingResult);

            int classifyResult = client.classify(text);
            System.out.println("classifyResult result: " + classifyResult);

            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
