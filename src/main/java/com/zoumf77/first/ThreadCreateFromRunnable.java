package com.zoumf77.first;

/**
 * 创建一个线程,首先通过实现Runnable接口，通常实现Runnable接口的类称之为任务，
 * 然后把任务作为线程的构造函数的参数，实例化一个线程类，
 * 推荐用这种防范，这样这个任务类还可以是其他类的子类
 * @author zmf
 *
 */
public class ThreadCreateFromRunnable implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("first implements Runnable,then creates a instance of  thread");
	}

	public static void main(String[] args) {
		ThreadCreateFromRunnable task=new ThreadCreateFromRunnable();
		Thread t=new Thread(task,"another thread");
		System.out.println(t.getName());
		
		t.start();
		
		
	}
}
