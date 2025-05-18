package com.example.demo.service;

import java.time.LocalDate;

import com.example.demo.model.Filme;
import com.example.demo.model.FilmeAssistido;
import com.example.demo.model.Usuario;

public class FilmeService {
    public static boolean adicionarFilmeParaAssistir(Usuario usuario, Filme filme) {
        for (Filme f : usuario.getFilmesParaAssistir()) {
            if (f.getNome().equalsIgnoreCase(filme.getNome())) {
                return false;
            }
        }
        usuario.getFilmesParaAssistir().add(filme);
        return true;
    }

    public static void marcarComoAssistido(Usuario usuario, String nomeFilme) {
        Filme encontrado = null;
        for (Filme f : usuario.getFilmesParaAssistir()) {
            if (f.getNome().equalsIgnoreCase(nomeFilme)) {
                encontrado = f;
                break;
            }
        }

        if (encontrado != null) {
            usuario.getFilmesParaAssistir().remove(encontrado);
            usuario.getFilmesAssistidos().add(
                new FilmeAssistido(
                    encontrado.getNome(),
                    encontrado.getGenero(),
                    encontrado.getAno(),
                    LocalDate.now()
                )
            );
        }
    }

    public static void removerFilmeParaAssistir(Usuario usuario, String nomeFilme) {
        usuario.getFilmesParaAssistir().removeIf(f -> f.getNome().equalsIgnoreCase(nomeFilme));
    }
}
