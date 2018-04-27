package com.asgc.concurrent.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
	
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
	private MyThreadLocal<Integer> myThreadLocal;
	
	public Data3(final int num){
		
		this.myThreadLocal = new MyThreadLocal() {
			
			@Override
			protected Integer initialValue() {
				
				return num;
			}
		};
		
	}
	
	public int get(){
		int ret = myThreadLocal.get();
		myThreadLocal.set(ret + 1);
		
		return ret;
	}
}

abstract class MyThreadLocal<T>{
	
	private Map<Long,T> cache;
	
	public MyThreadLocal(){
		cache = new HashMap<Long,T>();
	}
	
	protected abstract T initialValue();
	
	public void set(T value){
		cache.put(Thread.currentThread().getId(), value);
	}
	
	public T get(){
		if(!cache.containsKey(Thread.currentThread().getId())){
			this.set(initialValue());
		}
		
		return cache.get(Thread.currentThread().getId());
	}
	
}

