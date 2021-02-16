package com.rakuten.productmanagement.utils;

public enum Status {


	UNFULFILLED(0),  
	FULFILLED(1),
	PENDING(2); 
	
	public final int value;
	
	private Status(int value)
    {
		this.value = value;
    }
	
	 public int getValue() {
	        return value;
	    }

}
