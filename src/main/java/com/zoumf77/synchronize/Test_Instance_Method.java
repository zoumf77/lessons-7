package com.zoumf77.synchronize;

public class Test_Instance_Method {
	
	/*
	 * A线程调用实例方法1
	 */
	private static class A_Instance_Method implements Runnable{
		SynDemo synDemo;
		
		A_Instance_Method(SynDemo synDemo){
			this.synDemo=synDemo;
		}
		public void run() {
			// TODO Auto-generated method stub
			synDemo.method1();
		}
		
	}
	
	/*
	 * B线程调用实例方法2
	 */
	private static class B_Instance_Method implements Runnable{
		SynDemo synDemo;
		
		B_Instance_Method(SynDemo synDemo){
			this.synDemo=synDemo;
		}
		public void run() {
			// TODO Auto-generated method stub
			synDemo.method2();
		}
		
	}

	public static void main(String[] args){
		SynDemo synDemo=new SynDemo();
		Thread a =new Thread(new A_Instance_Method(synDemo),"t1");
		Thread b =new Thread(new B_Instance_Method(synDemo),"t2");
		
		a.start();
		b.start();
	}
}
