package br.com.elegis.api.ExceptionHandler;

@SuppressWarnings("serial")
public class RegraNegocioException extends RuntimeException {

	public RegraNegocioException(String msg) {
		super(msg);
	}

}
