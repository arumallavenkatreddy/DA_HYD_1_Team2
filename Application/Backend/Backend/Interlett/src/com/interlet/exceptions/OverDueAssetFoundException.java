package com.interlet.exceptions;

@SuppressWarnings("serial")
public class OverDueAssetFoundException extends Exception {
	public OverDueAssetFoundException() {
		super("Over Due Asset Found");
	}
}
