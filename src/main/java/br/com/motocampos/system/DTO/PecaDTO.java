package br.com.motocampos.system.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PecaDTO {
	@NotBlank(message = "O nome é obrigatorio!")
	private String nomeDTO;
	@NotNull(message = "O preco é obrigatorio!")
	@PositiveOrZero(message = "O preço deve ser zero ou positivo!")
	private BigDecimal precoDTO;
	
	public String getNomeDTO() {
		return nomeDTO;
	}
	public void setNomeDTO(String nomeDTO) {
		this.nomeDTO = nomeDTO;
	}
	public BigDecimal getPrecoDTO() {
		return precoDTO;
	}
	public void setPrecoDTO(BigDecimal precoDTO) {
		this.precoDTO = precoDTO;
	}
	
	
	
	
}
