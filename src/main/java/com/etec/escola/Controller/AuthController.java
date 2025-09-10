package com.etec.escola.Controller;

import com.etec.escola.Models.Usuario;
import com.etec.escola.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") //Permite Acesso do brouser
public class AuthController {
    private final UsuarioService service;

    public AuthController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public Usuario cadastrarUser (@RequestBody Usuario usuario){
        return service.cadastrarNovoUsuario(usuario);

    }

    @PostMapping("/login")
    public String login(Usuario usuario){
        Usuario user = service.fazerLogin(usuario.getUsername(), usuario.getSenha());
          if (user != null){
              return "Login realizado"+ user.getUsername();

          }
          return "user ou senha invalido";
    }
}
