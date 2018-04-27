package com.asgc.concurrent.unsafe.singleton;

public class Test1 {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i <5;i++){
					Singleton.getInstance();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
					
			public void run() {
				for(int i = 0; i <5;i++){
					Singleton.getInstance();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i <5;i++){
					Singleton.getInstance();
				}
			}
		}).start();
	}
	
}
