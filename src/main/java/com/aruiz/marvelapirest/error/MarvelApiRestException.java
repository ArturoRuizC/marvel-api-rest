package com.aruiz.marvelapirest.error;

public class MarvelApiRestException extends RuntimeException {

	private static final long serialVersionUID = -3406539977141393081L;
	
	public MarvelApiRestException(String mensaje) {
		super(mensaje);
	}
	
	public MarvelApiRestException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
