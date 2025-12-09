package br.com.motocampos.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motocampos.system.model.Peca;

public interface PecaRepository  extends JpaRepository<Peca , Long>{
		
	Optional<Peca>findByNome(String nome);
	
	boolean existsByNome(String nome);
}
