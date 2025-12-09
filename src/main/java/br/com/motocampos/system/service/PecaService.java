package br.com.motocampos.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.motocampos.system.DTO.PecaDTO;
import br.com.motocampos.system.model.Peca;
import br.com.motocampos.system.repository.PecaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PecaService {

	@Autowired
	PecaRepository pecaRepository;

	
	public void cadastrar(PecaDTO pecaDTO) {
		if(pecaRepository.existsByNome(pecaDTO.getNomeDTO())){
			throw new IllegalStateException("Ja existe uma peça com esse nome.");
		}
		Peca peca= Peca.criarNova(pecaDTO.getNomeDTO(), pecaDTO.getPrecoDTO());
		pecaRepository.save(peca);
	}
	
	public void atualizar(Long id, PecaDTO pecaDTO) {
		
		//Verificar se a peça existe
		Peca peca = pecaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Peça nao encontrada"));
		
		if(pecaDTO.getNomeDTO()!=null && !pecaDTO.getNomeDTO().isBlank()) {
			
			//verificar se ja existe outra peca com o mesmo nome
			boolean existeNomesIguais = pecaRepository.existsByNome(pecaDTO.getNomeDTO()) && 
										!pecaDTO.getNomeDTO().equals(peca.getNome()); //Verifica se o nome da peca é a mesma da DTO
			
			if(existeNomesIguais) {
				throw new IllegalArgumentException("Ja existe peca com esse nome.");
			}
			
			peca.renomear(pecaDTO.getNomeDTO());
		}
		//validacao do preco
		if(pecaDTO.getPrecoDTO()!=null) {
			peca.atualizarPreco(pecaDTO.getPrecoDTO());
		}
		pecaRepository.save(peca);
	
	}
	
}
