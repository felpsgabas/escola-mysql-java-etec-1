package com.etec.escola.Service;

import com.etec.escola.Interface.AuthUsuarioRepository;
import com.etec.escola.Models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final AuthUsuarioRepository userRepor;

    public UsuarioService(AuthUsuarioRepository usuarioRepository) {
        this.userRepor = usuarioRepository;

    }
    public Usuario fazerLogin(String username, String senha){
        return userRepor.findByUsernameAndSenha(username, senha).orElse(null);

    }


    public Usuario cadastrarNovoUsuario(Usuario user){
        return userRepor.save(user);

}
