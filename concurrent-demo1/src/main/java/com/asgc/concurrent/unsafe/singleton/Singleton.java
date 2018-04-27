package com.asgc.concurrent.unsafe.singleton;

public class Singleton {

	private static volatile Singleton singleton = null;
	
	private Singleton(){

	}
	
	public static Singleton getInstance(){
		if(null == singleton){
			synchronized (Singleton.class) {
				if(null == singleton){
					singleton = new Singleton();
				}
			}
		}
		
		return singleton;
	}
	
}
