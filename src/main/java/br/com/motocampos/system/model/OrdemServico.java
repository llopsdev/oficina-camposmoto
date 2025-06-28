package br.com.motocampos.system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
	private LocalDateTime dataAbertura;
	private LocalDateTime dataConclusao;
	@Column(precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico SoS;
	@ManyToOne
	private Moto moto;
}