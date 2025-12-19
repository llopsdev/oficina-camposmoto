package br.com.motocampos.system.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EntradaEstoqueDTO {

	@NotNull(message = "A quantidade é Obrigatorio")
	@Positive(message = "A quantidade tem que ser maior que 0")
	private Integer qtd;

	public Integer getQtd() {
		return qtd;
	}

	private void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	
	
	
}
