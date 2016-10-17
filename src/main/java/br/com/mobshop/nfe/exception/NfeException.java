package br.com.mobshop.nfe.exception;

import org.apache.log4j.Logger;

public class NfeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(NfeException.class);

	public NfeException() {
		super();
	}
	
	public NfeException(String message) {
		super(message);
		logger.error(message);
	}
	
}
