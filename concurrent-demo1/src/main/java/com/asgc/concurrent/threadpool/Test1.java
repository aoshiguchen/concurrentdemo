package com.asgc.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Future<Integer> future =  executorService.submit(new Callable<Integer>() {

			public Integer call() throws Exception {
				Thread.sleep(3000);
				return 10;
			}
			
		});
		
		System.out.println("hello world ");
		System.out.println(future.get());
	}
	
}
