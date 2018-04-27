package com.asgc.concurrent.threadlocal;

//参考教程 http://www.cnblogs.com/dolphin0520/p/3920407.html
public class Test2 {
	
	public static void main(String[] args) {
		
		final Data2 data = new Data2(0);
		
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

class Data2{
	private ThreadLocal<Integer> threadLocal;
	
	public Data2(final int num){
		
		threadLocal = new ThreadLocal<Integer>(){

			@Override
			protected Integer initialValue() {
				return num;
			}
			
		};
		
	}
	
	public int get(){
		int ret = threadLocal.get();
		
		threadLocal.set(ret + 1);
		
		return ret;
	}
}
