package br.com.motocampos.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motocampos.system.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Integer>{

}
