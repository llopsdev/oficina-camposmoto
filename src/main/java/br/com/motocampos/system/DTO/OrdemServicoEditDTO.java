package br.com.motocampos.system.DTO;

import java.math.BigDecimal;

import br.com.motocampos.system.enums.StatusOrdemServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrdemServicoEditDTO {

	private Long id;
	
	@NotBlank(message = "A Descrição é obrigatoria.")
	private String descricao;
	
	@NotNull(message = "O valor é obrigatorio.")
	@Positive(message = "o valor deve ser positivo.")
	private BigDecimal valor;
	private String observacoes;
	
	@NotNull(message = "O status é Obrigatorio.")
	private StatusOrdemServico status;
	private Long motoId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public Long getMotoId() {
		return motoId;
	}
	public void setMotoId(Long motoId) {
		this.motoId = motoId;
	}
	
	
}
