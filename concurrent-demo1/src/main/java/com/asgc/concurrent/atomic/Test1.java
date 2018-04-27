package com.asgc.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
	
	public static void main(String[] args) {
		final Data3 data = new Data3(0);
		
		new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i < 20; i++){
					System.out.println("线程：" + Thread.currentThread().getName() + "获取到" + data.get());
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i < 20; i++){
					System.out.println("线程：" + Thread.currentThread().getName() + "获取到" + data.get());
				}
			}
			
		}).start();
		
	}
	
}

class Data3{
	private AtomicInteger atomicInteger;
	
	public Data3(final int num){
		
		atomicInteger = new AtomicInteger(num);
	}
	
	public int get(){
		int ret = atomicInteger.get();
		atomicInteger.set(ret + 1);
				
		return ret;
	}
}

