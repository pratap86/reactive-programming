package com.pratap.reactive.basic;


public class PushBackDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main thread is Running...");
		
		Runnable r = () -> {
			new PushBackDemo().runningAsync(
					
					new PushBack() {
						
						@Override
						public void pushError(Exception ex) {

							System.out.println("Pushback error called, Got an exception "+ex);
						}
						
						@Override
						public void pushData(String data) {

							System.out.println("Pushback data :"+data);
						}
						
						@Override
						public void pushComplete() {

							System.out.println("Pushback done..");
						}
					}
					
					);
			
		};
		Thread t = new Thread(r);
		t.start();
		Thread.sleep(2000);
		System.out.println("Main thread compleated..");

	}

	public void runningAsync(PushBack pushback) {
		System.out.println("I am running in separate thread");
		sleep(1000);
		pushback.pushData("data1");
		pushback.pushData("data2");
		pushback.pushData("data3");
		
		pushback.pushError(new RuntimeException("Oops!"));
		pushback.pushComplete();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
