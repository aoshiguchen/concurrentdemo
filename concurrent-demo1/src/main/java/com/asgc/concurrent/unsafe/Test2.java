package com.asgc.concurrent.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

//参考资料 https://www.cnblogs.com/pkufork/p/java_unsafe.html
//https://blog.csdn.net/sherld/article/details/42492259
public class Test2 {

	public static void main(String[] args) throws Exception {
		//报错，因为jdk1.9之前，java只允许系统类加载器加载的类使用
		//Unsafe unsafe = Unsafe.getUnsafe();
		
		Field f = Unsafe.class.getDeclaredField("theUnsafe");
		f.setAccessible(true);
		Unsafe unsafe = (Unsafe) f.get(null);
		
		Class clazz = Person.class;
		Person person = (Person) unsafe.allocateInstance(clazz);
		
		person.sayHello();
	}
	
}
