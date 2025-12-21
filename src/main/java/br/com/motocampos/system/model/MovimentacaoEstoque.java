package br.com.motocampos.system.model;

import java.time.LocalDateTime;

import br.com.motocampos.system.enums.TipoMovimentacaoEstoque;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MovimentacaoEstoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="peca_id", nullable = false)
	private Peca peca;
	private Integer quantidade;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;
	private LocalDateTime localDateTime;
	
	public MovimentacaoEstoque() {
		
	}
	public MovimentacaoEstoque(Peca peca, Integer quantidade, TipoMovimentacaoEstoque tipoMovimentacaoEstoque, LocalDateTime localDateTime) {
		super();
		
		this.peca = peca;
		this.quantidade = quantidade;
		this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
		this.localDateTime = localDateTime;
	}


	public Long getId() {
		return id;
	}

	public Peca getPeca() {
		return peca;
	}


	public void setPeca(Peca peca) {
		this.peca = peca;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public TipoMovimentacaoEstoque getTipoMovimentacaoEstoque() {
		return tipoMovimentacaoEstoque;
	}


	public void setTipoMovimentacaoEstoque(TipoMovimentacaoEstoque tipoMovimentacaoEstoque) {
		this.tipoMovimentacaoEstoque = tipoMovimentacaoEstoque;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	
	

}
