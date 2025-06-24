package br.com.motocampos.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import br.com.motocampos.system.model.Cliente;
import jakarta.persistence.EntityManager;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

	Optional<Cliente>findByCpf(String cpf);
	Optional<Cliente>findByNome(String nome);
		
		 
	
}
