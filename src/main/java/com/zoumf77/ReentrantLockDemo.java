package com.zoumf77;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 通过这个例子讲解RentrantLock与synchronized的区别
 * @author zmf
 */
public class ReentrantLockDemo {
	Lock lock=new ReentrantLock();
	private int value;
	
	public int getValue(){
		lock.lock();
		try{
			
		}finally{
			lock.unlock();
		}
		
		return value;
		
	}
	
	
	public void setValue(int value){
		lock.lock();
		try{
			this.value=value;
		}finally{
			lock.unlock();
		}
	}
	
	private static class ThreadA implements Runnable{
		
		ReentrantLockDemo demo;
		ThreadA(ReentrantLockDemo demo){
			this.demo=demo;
		}
		public void run() {
			// TODO Auto-generated method stub
			demo.setValue(demo.getValue()+1);
		}
		
		
	}
	
	public static void main(String[] args){
		
		ReentrantLockDemo demo=new ReentrantLockDemo();
		
		for(int i=0;i<2;i++){
			Thread t=new Thread(new ThreadA(demo),"t"+i);
			t.start();
		}
		
		System.out.println(demo.getValue());
	}
}
