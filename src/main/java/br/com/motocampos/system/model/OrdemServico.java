package br.com.motocampos.system.model;

import java.math.BigDecimal;
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
	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	@ManyToOne
	private Moto moto;
	
	public OrdemServico() {
		
	}
	


	public OrdemServico(Long id, String descricao, LocalDateTime dataAbertura, LocalDateTime dataConclusao,
			BigDecimal valor, StatusOrdemServico status, Moto moto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataConclusao = dataConclusao;
		this.valor = valor;
		this.status = status;
		this.moto = moto;
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