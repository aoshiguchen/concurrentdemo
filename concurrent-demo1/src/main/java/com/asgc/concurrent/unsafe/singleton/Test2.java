package com.asgc.concurrent.unsafe.singleton;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
//https://blog.csdn.net/ITer_ZC/article/details/40820919
public class Test2 {

	public static void main(String[] args) throws Exception{
		
		
		System.out.println(getSingleton() == Singleton.getInstance());
	}
	
	public static Singleton getSingleton(){
		Singleton singleton = null;
		
		try{
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			Unsafe unsafe = (Unsafe) f.get(null);
			
			Class clazz = Singleton.class;
			singleton = (Singleton) unsafe.allocateInstance(clazz);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return singleton;
	}
}
