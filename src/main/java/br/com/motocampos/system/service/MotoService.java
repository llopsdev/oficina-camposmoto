package br.com.motocampos.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.motocampos.system.model.Cliente;
import br.com.motocampos.system.model.Moto;
import br.com.motocampos.system.repository.MotoRepository;

@Service
public class MotoService {

	private final MotoRepository motoRepository;
	
	public MotoService(MotoRepository motoRepository) {
		this.motoRepository=motoRepository;
	}
	
	public void save(Moto moto) {
		motoRepository.save(moto);
	}
	
	public List<Moto> findAll(){
		return motoRepository.findAll();
	}
	
	public Optional<Moto> findById(Long id){
		return motoRepository.findById(id);
	}
	
	public Optional<Moto> buscarPorPlaca (String placa){
		return motoRepository.findByPlaca(placa);
	}
	public void delete(Moto moto) {
		motoRepository.delete(moto);
	}
	
}
