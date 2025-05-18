package com.example.demo.model;

public class Filme {
    private String nome;
    private String genero;
    private int ano;

    public Filme(String nome, String genero, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}
