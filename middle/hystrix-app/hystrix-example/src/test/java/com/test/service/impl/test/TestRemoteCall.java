package com.test.service.impl.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.service.IRemoteCall;
import com.test.service.impl.RemoteCall;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRemoteCall {

	@Autowired
	private IRemoteCall remoteCall;

	@Test
	public void testRemoteCall() throws Exception {
		assertThat(this.remoteCall.call("test"), is("FALLBACK: test"));
		assertThat(this.remoteCall.call("test"), is("FALLBACK: test"));
		assertThat(this.remoteCall.call("test"), is("test"));
	}

	@Configuration
	@EnableAutoConfiguration
	// @EnableAspectJAutoProxy
	@EnableHystrix
	public static class SpringConfig {

		/*
		 * @Bean public HystrixCommandAspect hystrixCommandAspect() { return new
		 * HystrixCommandAspect(); }
		 */

		@Bean
		public IRemoteCall call() {
			return new RemoteCall();
		}
	}
}