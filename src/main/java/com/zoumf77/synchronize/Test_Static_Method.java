package com.zoumf77.synchronize;

public class Test_Static_Method {
	
	private static class A_Static_Method implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			SynDemo.syn_static_method1();
		}
		
	}
	
	
	private static class B_Static_Method implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			SynDemo.syn_static_method2();
		}
		
	}
	
	public static void main(String[] args){
		Thread a=new Thread(new A_Static_Method(),"t1");
		Thread b=new Thread(new B_Static_Method(),"t1");
		
		a.start();
		b.start();
	}

}
