package com.pratap.reactive.rx;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String[] args) {

		Observable<String> source = Observable.create( e -> {
			e.onNext("Hello");
			e.onNext("RXJava");
		});
		
		source.subscribe(System.out::println);
	}

}
