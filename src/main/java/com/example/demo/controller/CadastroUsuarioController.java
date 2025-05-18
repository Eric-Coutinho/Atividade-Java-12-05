package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class CadastroUsuarioController {
    @GetMapping("/cadastroUsuario")
    public String form() {
        return "cadastroUsuario";
    }

    @PostMapping("/cadastroUsuario")
    public String cadastrar(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        boolean sucesso = UsuarioService.cadastrarUsuario(usuario);
        return sucesso ? "redirect:/login" : "cadastroUsuario";
    }
}
