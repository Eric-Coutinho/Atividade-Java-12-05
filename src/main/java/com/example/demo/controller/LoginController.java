package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "index"; 
    }

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) { 
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login"; 
        }
        
        model.addAttribute("usuario", usuario);
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        System.out.println("Login attempt for email: " + email); 
        Usuario usuario = UsuarioService.autenticar(email, senha); 
        if (usuario != null) {
            System.out.println("Authentication successful for email: " + email); 
            session.setAttribute("usuario", usuario); //
            return "redirect:/home"; //
        }
        System.out.println("Authentication failed for email: " + email); 
        return "index"; 
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/login"; 
    }
}