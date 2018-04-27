package com.asgc.concurrent.lock.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁
//参考教程：http://www.cnblogs.com/dolphin0520/p/3923167.html
public class Test3 {
	
	private List<Integer> list = new ArrayList<Integer>();
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		final Test3 test = new Test3();
		
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
		if(lock.tryLock()) { //获取到锁立即返回true，没获取到锁立即返回false，不会阻塞 (可以设置一个最大等待时间)
			try {
	            System.out.println(thread.getName()+"得到了锁");
	            for(int i=0;i<5000;i++) {
	            	list.add(i);
	            }
	        } catch (Exception e) {
	          
	        }finally {
	            System.out.println(thread.getName()+"释放了锁");
	            lock.unlock();
	        }
		}else{
			System.out.println(thread.getName()+"获取锁失败");
		}
    }
}