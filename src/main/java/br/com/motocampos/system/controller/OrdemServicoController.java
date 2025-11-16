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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.motocampos.system.DTO.OrdemServicoEditDTO;
import br.com.motocampos.system.enums.StatusOrdemServico;
import br.com.motocampos.system.model.Moto;
import br.com.motocampos.system.model.OrdemServico;
import br.com.motocampos.system.service.MotoService;
import br.com.motocampos.system.service.OrdemServicoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	private final OrdemServicoService service;
	private final MotoService motoService;
	
	public OrdemServicoController(OrdemServicoService service,MotoService motoService) {
		this.service=service;
		this.motoService=motoService;
	}
	@GetMapping("/{id}/editar")
	public String abrirFormularioEdicao(@PathVariable Long id, Model model) {
		OrdemServico os = service.findByIdOrThrow(id);
		
		OrdemServicoEditDTO dto = service.toDTO(os);
		
		model.addAttribute("ordemServicoEditDTO",dto);
		model.addAttribute("ordemId",id);
		model.addAttribute("statusList", StatusOrdemServico.values());
		return "ordens/editar-ordem-servico";//path do thymeleaf
	}
	@PostMapping("/{id}/editar")
	public String salvarEdicao(@PathVariable Long id,
			@Valid @ModelAttribute("ordemServicoEditDTO") OrdemServicoEditDTO dto,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {
		 if(bindingResult.hasErrors()) {
			 model.addAttribute("statusList", StatusOrdemServico.values());
			 model.addAttribute("ordemId",id);
			 return "ordens/editar-ordem-servico";
		 }
		 
		 try {
			 service.editarOrdemServico(id, dto);
			 redirectAttributes.addFlashAttribute("sucesso", "Ordem de serviço atualizada com Sucesso");
			 return "redirect:/ordens-servico/" + id + "/detalhe";
		 }catch(IllegalStateException ex) {
			 bindingResult.reject("globalError",ex.getMessage());
			 model.addAttribute("statusList", StatusOrdemServico.values());
			 model.addAttribute("ordemId",id);
			 return "ordens/editar-ordem-servico";
		 }
	}
	
	@GetMapping("/form")
	public String mostrarFormOrdem(Model model) {
		OrdemServico ordemServico= new OrdemServico();
		model.addAttribute("ordemServico",ordemServico);
		model.addAttribute("motos",motoService.findAll());
		model.addAttribute("status",StatusOrdemServico.values());
		
		return "ordens/form-ordemServico";
	}
	
	@GetMapping
	public String listarOrdens(Model model){
		List<OrdemServico> list = service.findAll();
		model.addAttribute("ordensServico",list);
		return "ordens/listar";
		
	}
	
	@PostMapping
	public String salvarOs(@RequestParam Long motoId,   OrdemServico ordemServico) {
		Moto moto = motoService.findById(motoId).orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));
		
		ordemServico.setMoto(moto);
		service.save(ordemServico);
		return "redirect:/ordens-servico";
	}
	
	@GetMapping("/{id}")
	public String detalharOrdem(@PathVariable Long id, Model model) {
		OrdemServico ordemServico= service.findById(id).orElseThrow(() -> new IllegalArgumentException());
		
		model.addAttribute("ordem", ordemServico);
		model.addAttribute("moto", ordemServico.getMoto());
		model.addAttribute("cliente", ordemServico.getMoto() != null ? ordemServico.getMoto().getCliente() : null);
		
		return "ordens/detalhes";
		
	}
	@GetMapping("/{id}/status")
	public String editarStatus(@PathVariable Long id, Model model) {
		OrdemServico ordem = service.buscarPorId(id);
		model.addAttribute("ordem",ordem);
		model.addAttribute("statusList", StatusOrdemServico.values());
		return "ordens/editar-status";
		
	}
	@PostMapping("/{id}/status")
	public String atualizarStatus(@PathVariable Long id, @RequestParam("status") StatusOrdemServico novoStatus) {
		service.atualizarStatus(id, novoStatus);
		return "redirect:/ordens-servico";
	}
	
}
