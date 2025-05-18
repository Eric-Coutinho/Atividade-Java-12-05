package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Filme;
import com.example.demo.model.Usuario;
import com.example.demo.service.FilmeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FilmeController {
    @GetMapping("/cadastroFilme")
    public String formFilme() {
        return "cadastroFilme";
    }

    @PostMapping("/cadastroFilme")
    public String cadastrarFilme(@RequestParam String nome, @RequestParam String genero, @RequestParam int ano, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        Filme novo = new Filme(nome, genero, ano);
        boolean sucesso = FilmeService.adicionarFilmeParaAssistir(usuario, novo);
        return sucesso ? "redirect:/home" : "cadastroFilme";
    }

    @PostMapping("/assistir")
    public String assistirFilme(@RequestParam String nome, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        FilmeService.marcarComoAssistido(usuario, nome);
        return "redirect:/home";
    }

    @PostMapping("/remover")
    public String removerFilme(@RequestParam String nome, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        FilmeService.removerFilmeParaAssistir(usuario, nome);
        return "redirect:/home";
    }
}
