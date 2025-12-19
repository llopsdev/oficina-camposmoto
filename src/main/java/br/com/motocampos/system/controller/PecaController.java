package br.com.motocampos.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.motocampos.system.DTO.EntradaEstoqueDTO;
import br.com.motocampos.system.DTO.PecaDTO;
import br.com.motocampos.system.DTO.SaidaEstoqueDTO;
import br.com.motocampos.system.model.Peca;
import br.com.motocampos.system.service.PecaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pecas")
public class PecaController {

	private final PecaService pecaService;

	public PecaController(PecaService pecaService) {
		this.pecaService=pecaService;
	}	
	
	@GetMapping
	public String listarPecas(Model model) {
		List<Peca> list = pecaService.findAll();
		model.addAttribute("pecas", list);
		return "pecas/listar";
	}
	
	@GetMapping("/form")
	public String mostrarFormPeca(Model model) {
		PecaDTO pecaDTO = new PecaDTO();
		model.addAttribute("pecaDTO", pecaDTO);
		
		return "pecas/form-peca";
		
	}
	@GetMapping("/{id}/editar")
	public String mostrarEditarPeca(@PathVariable Long id, Model model) {
		Peca peca = pecaService.findById(id);
		PecaDTO pecaDTO = pecaService.toDTO(peca);
		
		model.addAttribute("pecaDTO", pecaDTO);
		model.addAttribute("pecaId", id);
		
		return "pecas/editar-pecas";
	}
	@PostMapping("/{id}/editar")
	public String salvarEdicaoPeca(@PathVariable Long id, @Valid @ModelAttribute("pecaDTO") PecaDTO pecaDTO, BindingResult bindResult, RedirectAttributes redirecAttr) {
		if(bindResult.hasErrors()) {
			return "pecas/editar-pecas";
		}
		try {
			pecaService.atualizar(id, pecaDTO);
			redirecAttr.addFlashAttribute("Sucesso", "Peça editada com sucesso");
			return "redirect:/pecas";
		}catch(IllegalStateException ex) {
			bindResult.reject("peca.erro.global",ex.getMessage());
			return "pecas/editar-pecas";
		}
	}
	
	
	@PostMapping("/cadastrar")
	public String cadastrarPeca(@Valid @ModelAttribute("pecaDTO") PecaDTO pecaDTO, BindingResult bindResult, RedirectAttributes redirectAttr) {
		if(bindResult.hasErrors()) {
			return "pecas/form-peca";
		}
		try {
			pecaService.cadastrar(pecaDTO);
			redirectAttr.addFlashAttribute("SUCESSO", "peça gravada com sucesso");
			return "redirect:/pecas";
		}catch (IllegalStateException ex) {
			bindResult.reject("peca.duplicada", "Ja existe uma peça com esse nome");
			return "pecas/form-peca";
		}
		
		
	}
	@PostMapping("/{id}/entrada")
	public String entradaEstoque(@PathVariable Long id, @Valid EntradaEstoqueDTO entradaEstoqueDTO,
			BindingResult bindResult, RedirectAttributes redirectAttr) {
		if(bindResult.hasErrors()) {
			return "pecas/entrada-estoque";
		}
		try {
			Integer quantidade= entradaEstoqueDTO.getQtd();
			pecaService.entradaEstoque(id,quantidade);
			redirectAttr.addFlashAttribute("Sucesso", "Estoque gravado com sucesso");
			return "redirect:/pecas";
			
		}catch (IllegalStateException ex){
			bindResult.reject("global.erro.negocio",ex.getMessage());
			
			return "pecas/entrada-estoque";
		}
		
	}
	@PostMapping("/{id}/saida")
	public String saidaEstoque(@PathVariable Long id, @Valid SaidaEstoqueDTO saidaEstoqueDTO, 
			BindingResult bindResult, RedirectAttributes redirectAttr) 
	{
		if(bindResult.hasErrors()) {
			return "pecas/saida-estoque";
		}
		try {
			Integer quantidade = saidaEstoqueDTO.getQtd();
			pecaService.saidaEstoque(id, quantidade);
			redirectAttr.addFlashAttribute("Sucesso", "Retirada realizada com sucesso");
			return "redirect:/pecas";
		
		}catch(IllegalStateException ex) {
			bindResult.reject("global.erro.negocio",ex.getMessage());
			return "pecas/saida-estoque";
		}
	}
	
}
		
