package br.com.fiap.projetoibm.exception;

public class AutenticacaoException extends RuntimeException {

	private static final long serialVersionUID = 2826093289728231115L;

	public AutenticacaoException() {
		super();
	}
	
	public AutenticacaoException(String message) {
		super(message);
	}
}
