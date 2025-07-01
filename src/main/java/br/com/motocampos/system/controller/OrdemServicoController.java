package br.com.motocampos.system.controller;

import java.io.ObjectInputFilter.Status;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.motocampos.system.enums.StatusOrdemServico;
import br.com.motocampos.system.model.OrdemServico;
import br.com.motocampos.system.service.MotoService;
import br.com.motocampos.system.service.OrdemServicoService;

@Controller
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	private final OrdemServicoService service;
	private final MotoService motoService;
	
	public OrdemServicoController(OrdemServicoService service,MotoService motoService) {
		this.service=service;
		this.motoService=motoService;
	}
	
	
	@GetMapping("/form")
	public String mostrarFormOrdem(Model model) {
		OrdemServico ordemServico= new OrdemServico();
		model.addAttribute("ordemServico",ordemServico);
		model.addAttribute("motos",motoService.findAll());
		model.addAttribute("status",StatusOrdemServico.values());
		
		return "ordens/form-ordemServico";
	}
	
	@PostMapping
	public String salvarOs(OrdemServico ordemServico) {
		service.save(ordemServico);
		return "redirect:/ordens-servico";
	}
}
