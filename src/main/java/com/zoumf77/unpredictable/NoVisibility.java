package com.zoumf77.unpredictable;

import java.util.concurrent.TimeUnit;

/**
 * Java Effective 中文版3版，P264页，我就改了个名字，方便讲解，其他就不画蛇添足了
 * 
 * 
 *
 */

public class NoVisibility {
	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {

		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while (!stopRequested) {
					count++;
				}
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested=true;

	}

}
