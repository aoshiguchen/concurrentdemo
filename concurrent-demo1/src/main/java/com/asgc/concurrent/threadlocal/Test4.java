package com.asgc.concurrent.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
	
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

class Data4{
	private MyThreadLocal4<Integer> myThreadLocal;
	
	public Data4(int num){
		
		this.myThreadLocal = new MyThreadLocal4(num);
		
	}
	
	public int get(){
		int ret = myThreadLocal.get();
		myThreadLocal.set(ret + 1);
		
		return ret;
	}
}


class MyThreadLocal4<T>{
	
	private Map<Long,T> cache;
	private T initialValue;
	
	public MyThreadLocal4(T initialValue){
		cache = new HashMap<Long,T>();
		this.initialValue = initialValue;
	}
		
	public void set(T value){
		cache.put(Thread.currentThread().getId(), value);
	}
	
	public T get(){
		if(!cache.containsKey(Thread.currentThread().getId())){
			this.set(initialValue);
		}
		
		return cache.get(Thread.currentThread().getId());
	}
	
}