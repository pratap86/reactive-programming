package com.pratap.reactive.basic;

public interface PushBack {

	void pushData(String data);
	
	void pushComplete();
	
	void pushError(Exception ex);
}
