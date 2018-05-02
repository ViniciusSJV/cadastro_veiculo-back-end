package br.com.veiculo.validador;

public class GenericException extends Exception{
	
	private String campo;
	private String mensagem;

	public GenericException(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
    @Override
    public String toString() {
        return this.getClass().getName() + "\n" + campo + " " + mensagem;
    }
	
}
