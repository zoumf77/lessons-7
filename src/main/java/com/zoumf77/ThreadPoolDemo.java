package com.zoumf77;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	
	private static class Task implements Runnable{
		
		public void run(){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		/**
		 * Executors是个创建线程池的静态方法，提供一些默认配置来创建线程，创建一个单线程的Executor,输出的都是同一个线程名字
		 */
		/*
		Executor ex=Executors.newSingleThreadExecutor();
		
		for(int i=0;i<10;i++){
			ex.execute(new Task());
		}
		*/
		/**
		 * 创建固定长度的线程池，
		 * 输出时，可能看到3个不同的线程名，但是每个线程可能执行的次数不一样
		 */
		
		/*
		Executor ex1=Executors.newFixedThreadPool(3);
		
		for(int i=0;i<10;i++){
			ex1.execute(new Task());
		}
		*/
		/**
		 * 创建一个可缓存的线程池，如果线程池的规模超过了处理需求，就会回收空闲的线程
		 * 线程池的最大规模是Integer.MAX_VALUE
		 * 执行下面的程序，可以根据线程名，看看有几个线程被创建，活跃线程有几个
		 */
		Executor ex2=Executors.newCachedThreadPool();
		int threadCount=((ThreadPoolExecutor)ex2).getActiveCount();
		System.out.println("开始前活跃线程数="+threadCount);
		
		for(int i=0;i<10;i++){
			ex2.execute(new Task());
			threadCount=((ThreadPoolExecutor)ex2).getActiveCount();
			System.out.println("执行后活跃线程数="+threadCount);
		}
		
		threadCount=((ThreadPoolExecutor)ex2).getActiveCount();
		System.out.println("睡眠前活跃线程数="+threadCount);
		
		TimeUnit.SECONDS.sleep(3);
		threadCount=((ThreadPoolExecutor)ex2).getActiveCount();
		System.out.println("睡眠后活跃线程数="+threadCount);
		
		
	}

}
