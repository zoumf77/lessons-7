package com.zoumf77.first;

import java.util.Map;

/**
 *查找当前JVM的线程，最简单的示范
* Attach Listener、Signal Dispatcher、Finalizer、Reference都是jvm的内置线程:
*详细说明可参考: https://blog.csdn.net/rachel_luo/article/details/8920596
*
* Attal:h Listener :用于接收外部外部命令并响应，如jstack、jvisualvm;
*
* Signal Dispatcher: 接收Attach Listener的命 令负责分发命令到各模块;
* Finalizer:与垃圾回收相关; jvm会把将失去引用的对象包装成Finalizer对象
* Reference Handler:与Finalizer一起处理引用对象的回收问题;
* main:主线程
* 如果使用jvisualvm, 查看当前应用，还会显示其他线程，例如RMI，用于两个jvm通讯的;等等;
* 
* 测试1：只会输出5个线程；直接启动应用，运行结束；
* 测试2：把断点设置在Thread.getAllStackTraces();启动应用
*      然后启动jvisualvm,找到当前应用，点击“线程",就会发现比测试1多出几个线程，
*      然后把应用程序执行完，就能看到与jvisualvm看到的线程一样。
* @author zmf
*/
public class FirstThread {
	public static void main(String[] args) throws InterruptedException{
		Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
		
		for(Thread t : maps . keySet()){
			System.out.println(t.getName()+":"+t.getClass());
		}
		
		Thread.sleep(0);
	}
}
