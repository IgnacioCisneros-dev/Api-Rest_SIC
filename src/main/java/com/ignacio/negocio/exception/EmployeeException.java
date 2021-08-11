package com.ignacio.negocio.exception;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;

	private int codeError;

	public EmployeeException(String errorMessage, int codeError) {
		super(errorMessage);
		this.codeError = codeError;
	}

	public int getCodeError() {
		return codeError;
	}

	public void setCodeError(int codeError) {
		this.codeError = codeError;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
