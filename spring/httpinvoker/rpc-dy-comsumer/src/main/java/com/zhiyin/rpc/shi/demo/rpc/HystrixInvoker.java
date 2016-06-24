package com.zhiyin.rpc.shi.demo.rpc;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import org.springframework.remoting.httpinvoker.HttpInvokerClientConfiguration;
import org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by wangqinghui on 2016/6/24.
 */
public class HystrixInvoker extends SimpleHttpInvokerRequestExecutor {


    @Override
    protected RemoteInvocationResult doExecuteRequest(
            HttpInvokerClientConfiguration config, ByteArrayOutputStream baos)
            throws IOException, ClassNotFoundException {
        return doExcuteWithHystrix(config,baos);
    }

    public RemoteInvocationResult doExcuteWithHystrix(final HttpInvokerClientConfiguration config, final ByteArrayOutputStream baos)
            throws IOException, ClassNotFoundException{
        String service = config.getServiceUrl();
        if (StringUtils.isEmpty(service)) {
            return null;

        }

        logger.info(service);

        String masterName = "RPC";
        String commandKey = service.substring(service.lastIndexOf("/")+1);
        logger.info(commandKey);
        commandKey = "demoCk";

        commandKey = CommandKeyUtil.getCk("demoCk");
//        String[] splitService = service.split(";");
//        String masterName = splitService[0];
//        String subName = splitService[1];
//        String commandKey = subName + "Command";

        HystrixCommand.Setter theSetter = HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(masterName))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
                ;

        HystrixCommand<RemoteInvocationResult> theCommand = new HystrixCommand<RemoteInvocationResult>(theSetter) {
            @Override
            protected RemoteInvocationResult run() throws Exception {
                return parDoExecuteRequest(config, baos);
            }
            @Override
            protected RemoteInvocationResult getFallback(){
                return new RemoteInvocationResult(null);
            }
        };
        return theCommand.execute();
    }


    // 父类的方法
    protected RemoteInvocationResult parDoExecuteRequest(
            HttpInvokerClientConfiguration config, ByteArrayOutputStream baos)
            throws IOException, ClassNotFoundException {

        HttpURLConnection con = openConnection(config);
        prepareConnection(con, baos.size());
        writeRequestBody(config, con, baos);
        validateResponse(config, con);
        InputStream responseBody = readResponseBody(config, con);

        return readRemoteInvocationResult(responseBody, config.getCodebaseUrl());
    }

}
