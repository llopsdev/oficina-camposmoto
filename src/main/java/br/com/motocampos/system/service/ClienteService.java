package br.com.motocampos.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.motocampos.system.model.Cliente;
import br.com.motocampos.system.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepository;
	
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository=clienteRepository;
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Optional<Cliente> buscaPorCPF(String cpf){
		return clienteRepository.findByCpf(cpf);
	}
	public Optional<Cliente> buscaPorNome(String nome){
		return clienteRepository.findByNome(nome);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
