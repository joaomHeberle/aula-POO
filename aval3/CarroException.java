package aval3;

public class CarroException extends Exception {
	private String mensagem;

	public CarroException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}
}
