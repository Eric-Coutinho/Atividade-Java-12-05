package com.example.demo.model;

import java.time.LocalDate;

public class FilmeAssistido extends Filme { 
    private LocalDate dataAssistido;

    public FilmeAssistido(String nome, String genero, int ano, LocalDate dataAssistido) {
        super(nome, genero, ano); 
        this.dataAssistido = dataAssistido;
    }

    public LocalDate getDataAssistido() {
        return dataAssistido;
    }

    public void setDataAssistido(LocalDate dataAssistido) {
        this.dataAssistido = dataAssistido;
    }
}