package br.com.motocampos.system.DTO;

import br.com.motocampos.system.model.Endereco;

public class ClienteMotoDTO {
 
	//Campos CLientes
	private String nome;
	private String cpf;
	
	
	//Campos Moto
	
	private String marca;
	private String modelo;
	private String placa;
	
	
	public ClienteMotoDTO() {
		
	}


	public ClienteMotoDTO(String nome, String cpf, String marca, String modelo, String placa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	
	
}
