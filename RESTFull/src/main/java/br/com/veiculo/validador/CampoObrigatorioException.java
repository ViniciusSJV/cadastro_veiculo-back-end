package br.com.veiculo.validador;

public class CampoObrigatorioException extends Exception{
	
	private String fieldName;

	public CampoObrigatorioException(String string) {
		this.fieldName = fieldName;
	}
	
    @Override
    public String toString() {
        return this.getClass().getName() + "\n" + fieldName + " Obrigatorio";
    }
	
}
