package com.asgc.concurrent.runnable;

public class Test1 {

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + "运行");
			}
		}.start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + "运行");
			}
		}).start();
	}
	
}
