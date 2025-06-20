package br.com.motocampos.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "clientes/form";
	}
	
	@PostMapping
	public String salvarCliente(Cliente cliente) {
		service.save(cliente);
		return "redirect:/clientes";
	}
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicao(@PathVariable Integer id, Model model) {
		Cliente cliente = service.buscarPorId(id).orElseThrow();
		model.addAttribute("cliente", cliente);
		return "clientes/form";
	}
	@PostMapping
	public String deletarCliente(@RequestParam("id") Integer id) {
		Cliente cliente= service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
		return "redirect/clientes";
	}
	
	
}
