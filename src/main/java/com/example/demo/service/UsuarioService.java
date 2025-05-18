package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Usuario;

public class UsuarioService {
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("adm", "adm", "adm"));
    }

    public static Usuario autenticar(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public static boolean cadastrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }
}
