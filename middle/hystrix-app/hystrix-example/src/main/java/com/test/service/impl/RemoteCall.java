package com.test.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.service.IRemoteCall;

public class RemoteCall implements IRemoteCall {

	private IRemoteCall mockedDelegate;

	public RemoteCall() {
		try {
			mockedDelegate = mock(IRemoteCall.class);
			when(mockedDelegate.call(anyString()))
					.thenThrow(
							new RuntimeException(
									"Deliberately throwing an exception 1"))
					.thenThrow(
							new RuntimeException(
									"Deliberately throwing an exception 2"))
					.thenAnswer(new Answer<String>() {
						@Override
						public String answer(InvocationOnMock invocationOnMock)
								throws Throwable {
							return (String) invocationOnMock.getArguments()[0];
						}
					});
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
			@HystrixProperty(name = "execution.timeout.enabled", value = "true"),

			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
			@HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
			@HystrixProperty(name = "fallback.enabled", value = "true"),
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),

			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
			@HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
			@HystrixProperty(name = "circuitBreaker.forceClosed", value = "false")

	}, fallbackMethod = "fallBackCall", commandKey = "call", groupKey = "DummyRemoteCallService", threadPoolKey = "thread-pool-remote-call", threadPoolProperties = { @HystrixProperty(name = "coreSize", value = "5") }, ignoreExceptions = { IllegalAccessException.class })
	public String call(String request) throws Exception {
		return this.mockedDelegate.call(request);
	}

	public String fallBackCall(String request) {
		System.out.println("Fallback - " + request);
		return "FALLBACK: " + request;
	}
}