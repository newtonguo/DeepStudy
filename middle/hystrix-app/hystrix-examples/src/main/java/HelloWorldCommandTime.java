import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.*;
import com.netflix.hystrix.util.HystrixRollingNumberEvent;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by hg on 2016/1/21.
 */
//重载HystrixCommand 的getFallback方法实现逻辑
public class HelloWorldCommandTime extends HystrixCommand<String> {
    private final String name;
    public HelloWorldCommandTime(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup")).andCommandKey(HystrixCommandKey.Factory.asKey("TestTimeoutKey"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withRequestLogEnabled(true).withExecutionTimeoutInMilliseconds(500)));
        this.name = name;
    }
    @Override
    protected String getFallback() {
        return Thread.currentThread().getName() + "exeucute Falled";
    }

    @Override
    protected String run() throws Exception {
        //sleep 1 秒,调用会超时
        TimeUnit.MILLISECONDS.sleep(1000);
        return this.getCommandKey().name() + "Hello " + name +" thread:" + Thread.currentThread().getName();
    }
    public static void main(String[] args) throws Exception{


        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.TestTimeoutKey.execution.isolation.thread.timeoutInMilliseconds",
                5000);

        for(int i=0;i<10; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime("test-Fallback");
            String result = command.execute();
            System.out.println(result);
        }

        System.out.println();
        System.out.println();

        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.TestTimeoutKey.execution.isolation.thread.timeoutInMilliseconds",
                5000);

        for(int i=0;i<10; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime("test-Fallback");
            String result = command.execute();
            System.out.println(result);
        }

    }


}