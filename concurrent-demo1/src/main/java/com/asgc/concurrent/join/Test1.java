package com.asgc.concurrent.join;

public class Test1 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("abc");
				for(int i = 0 ;i < 100;i++);
				System.out.println("deb");
			}
			
		});
		t.start();
		t.join();
		System.out.println("123");
	}
	
}
