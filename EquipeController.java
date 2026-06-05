package com.guthinh0.projetoa3.controller;

import com.guthinh0.projetoa3.model.Equipe;
import com.guthinh0.projetoa3.service.EquipeService;
import com.guthinh0.projetoa3.service.ProjetoService;
import com.guthinh0.projetoa3.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService equipeService; private final UsuarioService usuarioService; private final ProjetoService projetoService;
    public EquipeController(EquipeService equipeService, UsuarioService usuarioService, ProjetoService projetoService){this.equipeService=equipeService; this.usuarioService=usuarioService; this.projetoService=projetoService;}
    @GetMapping public String listar(Model model){model.addAttribute("equipes", equipeService.listarTodas()); return "equipes/lista";}
    @GetMapping("/novo") public String novo(Model model){model.addAttribute("equipe", new Equipe()); carregar(model); return "equipes/form";}
    @PostMapping("/salvar") public String salvar(@Valid @ModelAttribute Equipe equipe, BindingResult result, Model model){if(result.hasErrors()){carregar(model); return "equipes/form";} equipeService.salvar(equipe); return "redirect:/equipes";}
    @GetMapping("/editar/{id}") public String editar(@PathVariable Long id, Model model){model.addAttribute("equipe", equipeService.buscarPorId(id)); carregar(model); return "equipes/form";}
    @GetMapping("/excluir/{id}") public String excluir(@PathVariable Long id){equipeService.excluir(id); return "redirect:/equipes";}
    private void carregar(Model model){model.addAttribute("usuarios", usuarioService.listarTodos()); model.addAttribute("projetos", projetoService.listarTodos());}
}
