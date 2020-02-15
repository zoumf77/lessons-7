package com.zoumf77.unpredictable;

import java.util.concurrent.TimeUnit;

/**
 * Java Effective 中文版3版，P264页，我就改了个名字，方便讲解，其他就不画蛇添足了
 * @author Joshua Bloch
 *
 */
public class VisibilityBySynchronize {
	private static boolean stopRequested;
	
	public static synchronized void requestStop(){
		stopRequested=true;
	}
	
	/*读操作同样要同步，否则就看不到写操作的，可以试着把synchronized修饰符去掉去运行一下*/
	public static synchronized boolean stopRequested(){
		return stopRequested;
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while (!stopRequested()) {
					count++;
				}
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
