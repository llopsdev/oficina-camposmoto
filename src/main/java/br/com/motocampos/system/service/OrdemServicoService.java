package br.com.motocampos.system.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.stereotype.Service;

import br.com.motocampos.system.enums.StatusOrdemServico;
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
	
	public OrdemServico atualizarStatus(Long id, StatusOrdemServico novoStatus) {
		OrdemServico ordem = ordemRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada"));
		
		ordem.atualizarStatus(novoStatus);
		
		return ordemRepository.save(ordem);
	}
	
	public OrdemServico buscarPorId(Long id) {
		return ordemRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada"));
	}
	public void delete(OrdemServico os) {
		ordemRepository.delete(os);
	}
}
