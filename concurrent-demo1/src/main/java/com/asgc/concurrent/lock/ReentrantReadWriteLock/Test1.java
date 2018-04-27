package com.asgc.concurrent.lock.ReentrantReadWriteLock;

//先看一下synchronized达到的效果：
//这段程序的输出结果会是，直到thread1执行完读操作之后，才会打印thread2执行读操作的信息。
//参考教程：http://www.cnblogs.com/dolphin0520/p/3923167.html
public class Test1 {     
    public static void main(String[] args)  {
        final Test1 test = new Test1();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
    }  
     
    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }
}
