package br.com.motocampos.system.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class SaidaEstoqueDTO {

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
