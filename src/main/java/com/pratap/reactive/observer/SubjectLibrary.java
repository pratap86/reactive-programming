package com.pratap.reactive.observer;
/**
 * Subject or Observable
 * @author 835698
 *
 */
public interface SubjectLibrary {

	/**
	 * subscribe to the subject library
	 * @param observer
	 */
	public void subscribeObserver(Observer observer);
	
	/**
	 * unsubscribe to the subject library
	 * @param observer
	 */
	public void unsubscribeObserver(Observer observer);
	
	/**
	 * notify to the end user if any changed happens in state to the observer
	 */
	public void notifyObserver();
	
}
