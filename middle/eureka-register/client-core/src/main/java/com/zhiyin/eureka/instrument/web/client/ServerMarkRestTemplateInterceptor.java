package com.zhiyin.eureka.instrument.web.client;

import com.zhiyin.eureka.instrument.web.client.support.RibbonFilterContextHolder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ServerMarkRestTemplateInterceptor
		implements ClientHttpRequestInterceptor {
    private String serverMark;

	public ServerMarkRestTemplateInterceptor(String serverMark) {
        this.serverMark = serverMark;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		// 启动时设置服务标签
        RibbonFilterContextHolder.getCurrentContext().add("serverMark", serverMark);
        return execution.execute(request,body);
	}

}
