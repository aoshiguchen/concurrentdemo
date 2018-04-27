package com.asgc.concurrent.threadlocal;

//参考教程 http://www.cnblogs.com/dolphin0520/p/3920407.html
//不使用ThreadLocal的情况
public class Test1 {
	
	public static void main(String[] args) {
		
		final Data1 data = new Data1(0);
		
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

class Data1{
	private int num;
	
	public Data1(int num){
		this.num = 0;
	}
	
	public int get(){
		
		return num++;
	}
}
