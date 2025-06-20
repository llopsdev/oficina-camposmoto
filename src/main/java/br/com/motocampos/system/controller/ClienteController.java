package br.com.motocampos.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.motocampos.system.model.Cliente;
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
	
	
}
