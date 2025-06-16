package com.projeto_poo.trabalho_p2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto_poo.trabalho_p2.model.Personagem;
import com.projeto_poo.trabalho_p2.model.PersonagemService;

@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }

    @GetMapping("/formulario")
    public String form(Model model) {
        // QUERO UM PERSONAGEM VAZIO NO FORMULARIO
        model.addAttribute("personagem", new Personagem());
        model.addAttribute("titulo", "CADASTRO DE PERSONAGEM");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id) {

        PersonagemService cs = ctx.getBean(PersonagemService.class);
        Personagem velho = cs.puxarPersonagem(id);

        model.addAttribute("personagem", velho);
        model.addAttribute("titulo", "EDITAR PERSONAGEM");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, @ModelAttribute Personagem persona, @PathVariable int id) {
        PersonagemService cs = ctx.getBean(PersonagemService.class);
        cs.atualizarPersonagem(id, persona);
        return "redirect:/listar";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Personagem persona) {
        PersonagemService cs = ctx.getBean(PersonagemService.class);
        cs.inserirPersonagem(persona);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        PersonagemService cs = ctx.getBean(PersonagemService.class);
        List<Personagem> lista = cs.puxarTodosPersonagens();
        model.addAttribute("personagens", lista);

        return "listar";

    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        PersonagemService cs = ctx.getBean(PersonagemService.class);
        cs.deletar(id);
        return "redirect:/listar";
    }

}
