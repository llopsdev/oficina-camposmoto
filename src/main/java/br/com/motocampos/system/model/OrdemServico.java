package br.com.motocampos.system.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.motocampos.system.enums.StatusOrdemServico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	private LocalDateTime dataAbertura = LocalDateTime.now();
	private LocalDateTime dataConclusao;
	@Column(precision = 10, scale = 2)
	private BigDecimal valor;
	private String observacoes;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	@ManyToOne
	private Moto moto;
	
	
	public OrdemServico() {
		
	}
	


	public OrdemServico(Long id, String descricao, LocalDateTime dataAbertura, LocalDateTime dataConclusao,
			BigDecimal valor,String observacoes, StatusOrdemServico status, Moto moto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataConclusao = dataConclusao;
		this.valor = valor;
		this.observacoes=observacoes;
		this.status = status;
		this.moto = moto;
		
	}
	
	public void atualizarStatus(StatusOrdemServico novoStatus) {
		//Garante que a O.S nao será alterada após concluida.
		if(this.status==StatusOrdemServico.CONCLUIDO) {
			throw new IllegalStateException("Não é permitido altarar o status de uma O.S ja Concluida");
		}
		//Valida a transicao de Status
		boolean transicaoValida= false;
		
		switch(this.status) {
		case ABERTO:
			transicaoValida=(novoStatus==StatusOrdemServico.EM_ANDAMENTO);
			break;
		case EM_ANDAMENTO:
			transicaoValida=(novoStatus == StatusOrdemServico.CONCLUIDO);
			break;
		default:
			transicaoValida=false;
		}
		
		if(!transicaoValida) {
			throw new IllegalArgumentException("Não é possivel alterar o status de: "+this.status+" para: "+novoStatus);
		}
		//atualiza o status
		this.status=novoStatus;
		
		//Registra a data e hora da conclusao
		if(novoStatus==status.CONCLUIDO) {
			this.dataConclusao=LocalDateTime.now();
		}
		
	}


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


	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}


	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
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
		this.observacoes=observacoes;
	}


	public StatusOrdemServico getStatus() {
		return status;
	}


	public void setStatus(StatusOrdemServico status) {
		this.status=status;
	}


	public Moto getMoto() {
		return moto;
	}


	public void setMoto(Moto moto) {
		this.moto = moto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}