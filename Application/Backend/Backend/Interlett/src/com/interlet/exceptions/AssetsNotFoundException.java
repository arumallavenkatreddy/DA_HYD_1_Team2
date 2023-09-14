package com.interlet.exceptions;

@SuppressWarnings("serial")
public class AssetsNotFoundException extends Exception {
	public AssetsNotFoundException() {
		super("Assets are not Found");
	}

}
