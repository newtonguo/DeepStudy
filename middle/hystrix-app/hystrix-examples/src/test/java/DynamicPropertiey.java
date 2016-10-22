import com.netflix.config.ConfigurationManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangqinghui on 2016/10/17.
 */
public class DynamicPropertiey {

    static String CommandKey = "DyPro";
    static int loopCount = 2;

    // hystrix 默认超时时间为1s，测试自己设置默认超时时间。
    @Test
    public void testDefaultTimeoutShort(){


        // 默认超时时间长
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                2000);

        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( "default-property",3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetFail);
        }


    }


    // 测试超时时间长
    @Test
    public void testDefaultTimeoutLong(){

        // 默认超时时间长
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                3000);
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( "default-property",2000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetSucc);
        }

    }


    @Test
    public void testDefaultTimeoutLongToShort(){

        // 默认超时时间长
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                4000);
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( "default-property",3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetSucc);
        }

        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                2000);
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( "default-property",3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetFail);
        }

    }

    //
    @Test
    public void testDefaultTimeoutLongToShort2(){

        // 默认超时时间长
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                2000);
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( CommandKey ,3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetFail);
            Assert.assertTrue(command.getProperties().executionTimeoutInMilliseconds().get() == 2000);
        }

        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command."+CommandKey+".execution.isolation.thread.timeoutInMilliseconds",
                "4000");
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( CommandKey, 3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetSucc);
        }


        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
                2000);
        for(int i=0;i< loopCount; i++){
            HelloWorldCommandTime command = new HelloWorldCommandTime( CommandKey ,3000);
            String result = command.execute();
            Assert.assertEquals(result,HelloWorldCommandTime.RetSucc);
            Assert.assertTrue(command.getProperties().executionTimeoutInMilliseconds().get() == 4000);
        }




    }



}
