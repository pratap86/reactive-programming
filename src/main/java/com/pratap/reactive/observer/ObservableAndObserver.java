package com.pratap.reactive.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {

	public static void main(String[] args) {

		ObservableCreate<Integer> source = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(@NonNull ObservableEmitter<@NonNull Integer> emitter) throws Throwable {

				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onComplete();
				} catch (Throwable e) {
					emitter.onError(e);
				}

			}
			
		});
		
		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("subscribed");
			}

			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println("onNext : "+t);
			}

			@Override
			public void onError(@NonNull Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("completed.");
			}
		};
		
		source.subscribe(observer);
	}

}
