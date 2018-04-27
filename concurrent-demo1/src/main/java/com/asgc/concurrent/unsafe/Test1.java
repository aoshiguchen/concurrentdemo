package com.asgc.concurrent.unsafe;

import java.lang.reflect.Constructor;

public class Test1 {
	
	public static void main(String[] args) throws Exception {
		Class<Person> clazz = Person.class;

		Person person = null;
		
		//报错，因为Person类没有无参构造方法
		//person = clazz.newInstance();
		
		//获得指定的构造方法
		Constructor c = clazz.getDeclaredConstructor(String.class);
		person = (Person) c.newInstance("李四");

		person.sayHello();
	}
	
	
}
