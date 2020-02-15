package com.zoumf77.first;
/**
 * 从Thread派生子类，override run().
 * @author zmf
 *
 */

public class ThreadCreateFromThread extends Thread{
	
	public void run(){
		System.out.println(Thread.currentThread().getName());
		System.out.println("Created as a subclass of Thread");
	}

	public static void main(String[] args){
		Thread t=new Thread(new ThreadCreateFromThread(),"t1");
		//Thread t=new ThreadCreateFromThread();
		System.out.println(t.getName());
		t.start();
	}
}
