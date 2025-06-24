package br.com.motocampos.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.motocampos.system.DTO.ClienteMotoDTO;
import br.com.motocampos.system.model.Cliente;
import br.com.motocampos.system.model.Moto;
import br.com.motocampos.system.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service =service;
	}
	
	@GetMapping
	public String listarClientes(Model model){
		List<Cliente> list = service.findAll();
		model.addAttribute("clientes",list);
		return "clientes/listar";
	}
	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		ClienteMotoDTO cmDTO = new ClienteMotoDTO();
		model.addAttribute("clienteMoto", cmDTO);
		return "clientes/form-completo";
	}
	
	@PostMapping
	public String salvarCliente(Cliente cliente) {
		service.save(cliente);
		return "redirect:/clientes";
	}
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
		Cliente cliente = service.buscarPorId(id).orElseThrow();
		model.addAttribute("cliente", cliente);
		return "clientes/form";
	}
	@PostMapping("/clientes/deletar")
	public String deletarCliente(@RequestParam("id") Long id) {
		Cliente cliente= service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
		return "redirect/clientes";
	}
	
	@PostMapping("/cadastro-completo")
	public String salvarComMoto(@ModelAttribute ClienteMotoDTO clienteMotoDTO) {
		
		System.out.println("DTO recebido: " + clienteMotoDTO.getNome() + " - " + clienteMotoDTO.getCpf());
	    System.out.println("Moto: " + clienteMotoDTO.getMarca() + " / " + clienteMotoDTO.getModelo() + " / " + clienteMotoDTO.getPlaca());


		Cliente cliente = new Cliente();
		cliente.setNome(clienteMotoDTO.getNome());
		cliente.setCpf(clienteMotoDTO.getCpf());
		
		
		//Essa condição é para validar o preenchimento dos campos da moto.
		boolean motoValida = 
				clienteMotoDTO.getPlaca()!= null && !clienteMotoDTO.getPlaca().isBlank() &&
				clienteMotoDTO.getMarca()!= null && !clienteMotoDTO.getMarca().isBlank() &&
				clienteMotoDTO.getModelo()!=null && !clienteMotoDTO.getModelo().isBlank();
		
		
		
		if(motoValida) {
			Moto moto = new Moto();
			moto.setPlaca(clienteMotoDTO.getPlaca());
			moto.setMarca(clienteMotoDTO.getMarca());
			moto.setModelo(clienteMotoDTO.getModelo());
			
			cliente.getMotos().add(moto);
			moto.setCliente(cliente);
		}
		
		service.save(cliente);
		return "redirect:/clientes";

		
	}
}
