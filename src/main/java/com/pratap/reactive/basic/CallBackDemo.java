package com.pratap.reactive.basic;


public class CallBackDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main thread is Running...");
		
		Runnable r = () -> new CallBackDemo().runningAsync(() -> System.out.println("callback is called"));
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(2000);
		System.out.println("Main thread compleated..");

	}

	public void runningAsync(CallBack callback) {
		System.out.println("I am running in separate thread");
		sleep(1000);
		callback.call();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
