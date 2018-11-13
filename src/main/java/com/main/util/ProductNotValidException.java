package com.main.util;

public class ProductNotValidException extends RuntimeException {

	/**
	 * @author Amol Suryavanshi
	 */
	
	private static final long serialVersionUID = -1034046454881995112L;

	public ProductNotValidException(String message){
		super(message);
	}
}
