package com.zoumf77.unpredictable;

import java.util.concurrent.TimeUnit;

/**
 * Java Effective 中文版3版，P264页，我就改了个名字，方便讲解，其他就不画蛇添足了
 * @author Joshua Bloch
 *
 */
public class VisibilityByVolatile {
	/**
	 * 注意volatile的使用条件
	 * 1：对变量的写入不依赖变量的当前值，或者你能确保只有单个线程更新变量的值；
	 * 2：该变量不会与其他状态变量一起纳入不变性条件中
	 * 3：在访问变量时不需要加锁；
	 * 详细可以参考下面网站jenkov大师的说明
	 * http://tutorials.jenkov.com/java-concurrency/volatile.html
	 */
	public volatile static boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException {

		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while (!stopRequested) {
					count++;
				}
				
				System.out.println("count="+count);
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested=true;
	}

}
