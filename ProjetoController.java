package com.guthinh0.projetoa3.controller;

import com.guthinh0.projetoa3.model.Projeto;
import com.guthinh0.projetoa3.model.StatusProjeto;
import com.guthinh0.projetoa3.service.ProjetoService;
import com.guthinh0.projetoa3.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
    private final ProjetoService projetoService;
    private final UsuarioService usuarioService;
    public ProjetoController(ProjetoService projetoService, UsuarioService usuarioService){this.projetoService=projetoService; this.usuarioService=usuarioService;}
    @GetMapping public String listar(Model model){model.addAttribute("projetos", projetoService.listarTodos()); return "projetos/lista";}
    @GetMapping("/novo") public String novo(Model model){model.addAttribute("projeto", new Projeto()); carregar(model); return "projetos/form";}
    @PostMapping("/salvar") public String salvar(@Valid @ModelAttribute Projeto projeto, BindingResult result, Model model){if(result.hasErrors()){carregar(model); return "projetos/form";} projetoService.salvar(projeto); return "redirect:/projetos";}
    @GetMapping("/editar/{id}") public String editar(@PathVariable Long id, Model model){model.addAttribute("projeto", projetoService.buscarPorId(id)); carregar(model); return "projetos/form";}
    @GetMapping("/excluir/{id}") public String excluir(@PathVariable Long id){projetoService.excluir(id); return "redirect:/projetos";}
    private void carregar(Model model){model.addAttribute("statusProjetos", StatusProjeto.values()); model.addAttribute("gerentes", usuarioService.listarGerentes());}
}
