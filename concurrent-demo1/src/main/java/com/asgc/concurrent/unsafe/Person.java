package com.asgc.concurrent.unsafe;

public class Person {

	private String name;
	
	public Person(String name){
		this.name = name;
	}
	
	public void sayHello(){
		System.out.println(this.name + " say: hello");
	}
	
}
