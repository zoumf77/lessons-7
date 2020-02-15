package com.zoumf77.unpredictable;

/**
 * 该程序的主要目的是说明线程的不同执行顺序对共享资源的结果影响
 * 使用调试交替执行线程
 * @author zmf
 *
 */

public class UnsafeOrder {
	private int items = 100;

	/**
	 * 订购库存件数，如果库存件数大于等于要订购的件数，则返回订购件数，否则返回0；
	 * 
	 * @param items
	 * @return
	 */
	public int orderItems(int items) {
		if (this.items >= items) {
			this.items = this.items - items;
			return items;
		} else
			return 0;

	}
	
	public int getItems(){
		return this.items;
	}
	
	
	/**
	 * 下单
	 */
	private static class OrderManager implements Runnable{
		UnsafeOrder unsafeOrder;
		int items;
		OrderManager(UnsafeOrder unsafeOrder ,int items){
			this.unsafeOrder=unsafeOrder;
			this.items=items;
		}
		
		public void run() {
			if (unsafeOrder.orderItems(items)>0)
				System.out.println(Thread.currentThread().getName()+"库存充足，下单成功");
			else
				System.out.println(Thread.currentThread().getName()+"没有足够库存了，下单失败");	
			
		}
		
	}
	
	public static void main(String[] args){
		UnsafeOrder unsafeOrder=new UnsafeOrder();
		for(int i=0;i<2;i++){
			Thread t=new Thread(new OrderManager(unsafeOrder,51),"t"+i);
			t.start();
		}
		
		
	}
}
