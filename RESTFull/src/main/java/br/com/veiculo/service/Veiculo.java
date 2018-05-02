package br.com.veiculo.service;

import br.com.veiculo.validador.Obrigatorio;
import br.com.veiculo.validador.Placa;

public class Veiculo {
	
	private Long id;
	@Obrigatorio
	@Placa
	private String placa;
	@Obrigatorio
	private String modelo;
	@Obrigatorio
	@Ano
	private Integer ano;
	@Obrigatorio
	private String cor;
	@Obrigatorio
    private boolean alugado;
    
    public Veiculo() {
		

	}
        
	public Veiculo(long id, String placa, String modelo, int ano, String cor, boolean alugado) {
		setId(id);
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
		setCor(cor);
		setAlugado(alugado);

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public boolean isAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
    
    


}
