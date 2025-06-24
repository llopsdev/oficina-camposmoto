package br.com.motocampos.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motocampos.system.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long>{

	Optional<Moto> findByPlaca(String placa);
}
