package com.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import rx.Observable;

import com.test.hystrix.command.CommandHelloWorld;
import com.test.hystrix.command.ObservableCommandHelloWorld;

@EnableCircuitBreaker
public class Application {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		String execute = new CommandHelloWorld("Arpit").execute();
		System.out.println(execute);

		Future<String> queue = new CommandHelloWorld("Arpit").queue();
		System.out.println(queue.get());

		Observable<String> observable = new CommandHelloWorld("Arpit")
				.observe();

		observable.subscribe((obj) -> {
			System.out.println(obj);
		});

		ObservableCommandHelloWorld observableCommandHelloWorld = new ObservableCommandHelloWorld(
				"Arpit");
		observableCommandHelloWorld.observe().subscribe((obj) -> {
			System.out.println(obj);
		});
	}
}
