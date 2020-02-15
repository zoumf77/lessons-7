package com.zoumf77.synchronize;

public class Test_Block_Method {

	private static class A_Block_Method implements Runnable {
		SynDemo synDemo;
		A_Block_Method(SynDemo synDemo){
			this.synDemo=synDemo;
		}
		public void run() {
			// TODO Auto-generated method stub
			synDemo.syn_block_method1();
		}

	}
	
	private static class B_Block_Method implements Runnable {
		SynDemo synDemo;
		B_Block_Method(SynDemo synDemo){
			this.synDemo=synDemo;
		}
		public void run() {
			// TODO Auto-generated method stub
			synDemo.syn_block_method2();
		}

	}
	
	
	/**
	 * 大家调试时，可以先让t1进入同步块，t2等待
	 * t1运行到wait()后
	 * t2进入同步块，执行完后，
	 * t1收到通知，继续执行
	 * 
	 * 那么大家可以试一试，先让t2进入同步块，执行完
	 * 再执行t1看看，看看t1的状态
	 * 
	 * t1会一直等待，所以解决这个问题的办法见：Effective Java中3版P277
	 */
	public static void main(String[] args){
		SynDemo synDemo=new SynDemo();
		
		Thread a=new Thread(new A_Block_Method(synDemo),"t1");
		Thread b=new Thread(new B_Block_Method(synDemo),"t2");
		
		a.start();
		b.start();
		
	}
}
