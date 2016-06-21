package com.test.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class CommandHelloWorld extends HystrixCommand<String> {

	private final String name;

	public CommandHelloWorld(String name) {
		super(Setter.withGroupKey(
				HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld"))
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter()
								.withExecutionTimeoutEnabled(true)));
		this.name = name;
	}

	@Override
	protected String run() {
		// a real example would do work like a network call here
		return "Hello " + name + "!";
	}
}
