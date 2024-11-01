package com.TrabajoPolizas.Polizas.service;

import com.TrabajoPolizas.Polizas.model.Usuario;
import com.TrabajoPolizas.Polizas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetailsService userDetailsService() {
        return username -> {
            Usuario usuario = usuarioRepository.findByUsername(username);
            return User.builder()
                    .username(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles(usuario.getRoles().split(","))
                    .build();
        };
    }


}
