package com.miaplicacion.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticuloNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3366525165040289007L;

	public ArticuloNotFoundException(Long id) {
		super("No se puede encontrar el articulo con la ID:  " + id);
	}
	
	
}
