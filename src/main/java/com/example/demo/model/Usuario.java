package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Filme> filmesParaAssistir = new ArrayList<>();
    private List<FilmeAssistido> filmesAssistidos = new ArrayList<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    public List<Filme> getFilmesParaAssistir() {
        return filmesParaAssistir;
    }

    public List<FilmeAssistido> getFilmesAssistidos() {
        return filmesAssistidos;
    }
}
