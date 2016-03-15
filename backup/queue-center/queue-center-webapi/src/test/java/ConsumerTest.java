import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

public class ConsumerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_HG_TEST");
        properties.put(PropertyKeyConst.AccessKey,  Config.acckey);
        properties.put(PropertyKeyConst.SecretKey,  Config.seckey);
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("HG_TEST", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}    
