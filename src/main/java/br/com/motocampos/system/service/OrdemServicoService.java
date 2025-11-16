package br.com.motocampos.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.motocampos.system.DTO.OrdemServicoEditDTO;
import br.com.motocampos.system.enums.StatusOrdemServico;
import br.com.motocampos.system.exeptions.ResourceNotFoundException;
import br.com.motocampos.system.model.OrdemServico;
import br.com.motocampos.system.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;

@Service
public class OrdemServicoService {
	
	private final OrdemServicoRepository ordemRepository;
	
	public OrdemServicoService(OrdemServicoRepository ordemRepository) {
		this.ordemRepository=ordemRepository;
	}
	
	public OrdemServico findByIdOrThrow(Long id) {
		return ordemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ordem de Serviço não encontrada"+id));
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
	@Transactional
	public OrdemServico editarOrdemServico(Long id, OrdemServicoEditDTO dto) {
		OrdemServico os = findByIdOrThrow(id);
		
		if(os.getStatus() == StatusOrdemServico.CONCLUIDO) {
			throw new IllegalStateException("Não é possivel editar uma Ordem de Serviço ja concluida");
		}
		
	os.setDescricao(dto.getDescricao());
	os.setValor(dto.getValor());
	os.setObservacoes(dto.getObservacoes());
	
	//Atualiza o Status
	StatusOrdemServico novoStatus;
	try {
		novoStatus=dto.getStatus();
	}catch (IllegalArgumentException ex) {
		throw new IllegalStateException("Status invalido: "+dto.getStatus());
	}
	
	if(novoStatus != os.getStatus()) {
		os.atualizarStatus(novoStatus);
	}
	return ordemRepository.save(os);
	
	}
	public OrdemServico buscarPorId(Long id) {
		return ordemRepository.findById(id).orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada"));
	}
	public void delete(OrdemServico os) {
		ordemRepository.delete(os);
	}
	public OrdemServicoEditDTO toDTO(OrdemServico os) {
		OrdemServicoEditDTO dto = new OrdemServicoEditDTO();
		dto.setDescricao(os.getDescricao());
		dto.setValor(os.getValor());
		dto.setObservacoes(os.getObservacoes());
		dto.setStatus(os.getStatus());
		return dto;
	}
}
