package com.asgc.concurrent.lock.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁(错误用法)
//第一个线程没释放锁，第二个线程却获得了锁，原因是Lock定义在了insert方法内部，两个线程持有的锁不同
//参考教程：http://www.cnblogs.com/dolphin0520/p/3923167.html
public class Test1 {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		final Test1 test = new Test1();
		
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
        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
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