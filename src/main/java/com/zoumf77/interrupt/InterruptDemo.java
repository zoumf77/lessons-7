package com.zoumf77.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
	private static class SleepDemo implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000*60*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("当前线程的中断标志"+Thread.currentThread().isInterrupted());
				e.printStackTrace();
			}
			
			System.out.println("当前线程的名称"+Thread.currentThread().getName());
			System.out.println("当前线程的中断标志"+Thread.currentThread().isInterrupted());
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread t=new Thread(new SleepDemo(),"t1");
		t.start();
		TimeUnit.SECONDS.sleep(10);
		t.interrupt();
		System.out.println("t1的中断标志"+t.isInterrupted());
	}
}
