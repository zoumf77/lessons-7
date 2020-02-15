package com.zoumf77.interrupt;

import java.util.concurrent.TimeUnit;

/*
 * 如果线程处于非等待状态，如果调用线程的interrupt(),会置中断标志为true，但是并不会影响线程的运行;
 * 除非扔出一个异常，否则中断标志一直为true;
 * @author zmf
 */
public class ForeveThread {
	private static class Ta extends Thread{
		public void run(){
			while(true);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread t=new Thread(new Ta(),"ta");
		
		TimeUnit.SECONDS.sleep(10);
		
		t.start();
		
		t.interrupt();
		
		System.out.println("t的中断标志0="+t.isInterrupted());
		
		//if(t.isInterrupted())
		//	throw new InterruptedException();
		
		System.out.println("t的中断标志1="+t.isInterrupted());
		
		
	}
}
