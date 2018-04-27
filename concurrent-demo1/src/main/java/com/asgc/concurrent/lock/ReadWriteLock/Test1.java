package com.asgc.concurrent.lock.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;


/*
ReadWriteLock也是一个接口，在它里面只定义了两个方法：
public interface ReadWriteLock {
    *//**
     * Returns the lock used for reading.
     *
     * @return the lock used for reading.
     *//*
    Lock readLock();
 
    *//**
     * Returns the lock used for writing.
     *
     * @return the lock used for writing.
     *//*
    Lock writeLock();
}
一个用来获取读锁，一个用来获取写锁。也就是说将文件的读写操作分开，分成2个锁来分配给线程，从而使得多个线程可以同时进行读操作。下面的ReentrantReadWriteLock实现了ReadWriteLock接口。
*/
public class Test1 {
	
	public static void main(String[] args) {
		ReadWriteLock lock;
	}
	
}
