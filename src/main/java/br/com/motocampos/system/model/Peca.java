package br.com.motocampos.system.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
	
	@OneToMany(mappedBy = "peca")	
	private List<MovimentacaoEstoque> listaMovimentacaoEstoque;
	
	private Peca() {
		
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

	private void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	private void setPreco(BigDecimal preco) {
		
		this.preco = preco;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	private void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public static Peca criarNova(String nomePeca,BigDecimal precoPeca) {
		if(nomePeca==null || nomePeca.isBlank()) {
			throw new IllegalArgumentException("Nome da Peça é Obrigatorio!");
		}
		if(precoPeca==null || precoPeca.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Preço da peça deve ser Obrigatorio!");
		}
		//Novo objeto para retornar o metodo
		Peca p= new Peca();
		p.nome=nomePeca;
		p.preco=precoPeca;
		p.quantidadeEstoque=0;
		
		return p;
		
	}
	
	
	public void addQuantidadeEstoque(Integer qtd) {
		if(qtd == null || qtd<0) {
			throw new IllegalArgumentException("A quantidade informada nao pode ser negativa ou nula.");
		}
		quantidadeEstoque+=qtd;
	}
	public void removerQuantidadeEstoque(Integer qtd) {
		if(qtd == null || qtd<0) {
			throw new IllegalArgumentException("A quantidade informada nao pode ser negativa.");
		}
		if(qtd>this.quantidadeEstoque) {
			throw new IllegalStateException("Estoque Insuficiente.");
		}
		quantidadeEstoque-=qtd;
	}
	
	public void atualizarPreco(BigDecimal novoPreco) {
		if(novoPreco==null || novoPreco.compareTo(BigDecimal.ZERO)<0) {
			throw new IllegalArgumentException("O preco nao pode ser Nulo nem Negativo");
		}
		this.preco=novoPreco;
	}
	
	public void renomear(String novoNome) {
		if(novoNome==null || novoNome.isBlank()) {
			throw new IllegalArgumentException("É Obrigatorio informar um nome.");
		}
		if(novoNome.equals(this.nome)) {
			throw new IllegalArgumentException("Nome deve ser diferente do nome atual.");
		}
		this.nome = novoNome;
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
