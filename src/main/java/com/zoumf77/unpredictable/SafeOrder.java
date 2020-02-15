package com.zoumf77.unpredictable;


public class SafeOrder {
	
	private int items = 100;

	/**
	 * 订购库存件数，如果库存件数大于等于要订购的件数，则返回订购件数，否则返回0；
	 * 
	 * @param items
	 * @return
	 */
	public synchronized int orderItems(int items) {
		if (this.items >= items) {
			this.items = this.items - items;
			return items;
		} else
			return 0;

	}
	
	public synchronized int getItems(){
		return this.items;
	}
	
	
	/**
	 * 下单
	 */
	private static class OrderManager implements Runnable{
		SafeOrder safeOrder;
		int items;
		OrderManager(SafeOrder safeOrder ,int items){
			this.safeOrder=safeOrder;
			this.items=items;
		}
		
		public void run() {
			if (safeOrder.orderItems(items)>0)
				System.out.println(Thread.currentThread().getName()+"库存充足，下单成功");
			else
				System.out.println(Thread.currentThread().getName()+"没有足够库存了，下单失败");	
			
		}
		
	}
	
	public static void main(String[] args){
		SafeOrder safeOrder=new SafeOrder();
		for(int i=0;i<2;i++){
			Thread t=new Thread(new OrderManager(safeOrder,51),"t"+i);
			t.start();
		}
		
		/*多执行几次，看看库存目前件数*/
		System.out.println(safeOrder.getItems());
		
	}

}
