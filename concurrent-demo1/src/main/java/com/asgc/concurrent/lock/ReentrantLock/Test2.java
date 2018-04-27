package com.asgc.concurrent.lock.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁
//参考教程：http://www.cnblogs.com/dolphin0520/p/3923167.html
public class Test2 {
	
	private List<Integer> list = new ArrayList<Integer>();
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		final Test2 test = new Test2();
		
		new Thread(new Runnable() {
			
			public void run() {
				test.insert(Thread.currentThread());
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				test.insert(Thread.currentThread());
				
			}
		}).start();
	}
	
	public void insert(Thread thread) {
        lock.lock(); //没有获取到锁会一直阻塞在这里，直到获取到锁才往下执行
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
            	list.add(i);
            }
        } catch (Exception e) {
           
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
	
}