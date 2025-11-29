package br.com.motocampos.system.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Peca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Column(precision = 10, scale = 2)
	@PositiveOrZero(message = "O valor deve ser positivo ou zero.")
	private BigDecimal preco;
	@PositiveOrZero
	private Integer quantidadeEstoque;
	
	public Peca() {
		
	}

	public Peca(Long id, String nome, BigDecimal preco, Integer quantidadeEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	private void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public void addQuantidadeEstoque(Integer qtd) {
		if(qtd<0) {
			throw new IllegalArgumentException("A quantidade informada nao pode ser negativa.");
		}
		quantidadeEstoque+=qtd;
	}
	public void removerQuantidadeEstoque(Integer qtd) {
		if(qtd<0) {
			throw new IllegalArgumentException("A quantidade informada nao pode ser negativa.");
		}
		if(qtd>this.quantidadeEstoque) {
			throw new IllegalStateException("Estoque Insuficiente.");
		}
		quantidadeEstoque-=qtd;
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
		Peca other = (Peca) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Peca [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	
	
	
}
