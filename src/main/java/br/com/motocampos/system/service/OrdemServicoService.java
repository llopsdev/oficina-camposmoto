package br.com.motocampos.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.motocampos.system.model.OrdemServico;
import br.com.motocampos.system.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	private final OrdemServicoRepository ordemRepository;
	
	public OrdemServicoService(OrdemServicoRepository ordemRepository) {
		this.ordemRepository=ordemRepository;
	}
	
	public void save(OrdemServico os) {
		ordemRepository.save(os);
	}
	
	public List<OrdemServico>findAll(){
		return ordemRepository.findAll();
	}
	
	public Optional<OrdemServico> findById(Long id) {
		return ordemRepository.findById(id);
	}
	
	public void delete(OrdemServico os) {
		ordemRepository.delete(os);
	}
}
