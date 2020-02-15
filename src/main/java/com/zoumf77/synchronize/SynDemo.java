package com.zoumf77.synchronize;

public class SynDemo {
	
	public static Object OBJECT_LOCK=new Object();
	
	/*实例方法*/
	public synchronized void method1(){
		System.out.println("non static method1");
	}
	
	/*实例方法*/
	public synchronized void method2(){
		System.out.println("non static method2");
	}
	
	/*静态方法*/
	public synchronized static void syn_static_method1(){
		System.out.println("syn_static_method1");
	}
	
	/*静态方法*/
	public synchronized static void syn_static_method2(){
		System.out.println("syn_static_method2");
	}
	

	/**
	 * 同步块
	 * 两个线程同时访问的话，那么有一个线程就会进入等待，如果OBJECT_LOCK.wait()执行后，
	 * 会释放OBJECT_LOCK的内置锁，另一个线程即可用
	 */
	public void syn_block_method1(){
		synchronized(OBJECT_LOCK){
			System.out.println("block_wait_method1");
			
			try {
				OBJECT_LOCK.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("syn_block_method1 continueing");
		}
	}
	
	/**
	 * 同步块
	 * 两个线程同时访问的话，那么有一个线程就会进入等待，如果OBJECT_LOCK.notify()执行后，
	 * 另一个先前调用 wait()的线程会继续执行
	 * notify()，只有一个线程能接到通知
	 * notifyAll(),有多个线程能接到通知
	 */
	public void syn_block_method2(){
		synchronized(OBJECT_LOCK){
			System.out.println("block_wait_method2");
			OBJECT_LOCK.notify();
		}
	}
}
