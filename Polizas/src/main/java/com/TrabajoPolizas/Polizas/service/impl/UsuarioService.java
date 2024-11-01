package com.TrabajoPolizas.Polizas.service.impl;

import com.TrabajoPolizas.Polizas.dtos.CrearUsuarioDTO;
import com.TrabajoPolizas.Polizas.dtos.UsuarioDTO;
import com.TrabajoPolizas.Polizas.model.Usuario;
import com.TrabajoPolizas.Polizas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario getByUsername(final String username) {
        return usuarioRepository.findByUsername(username);
    }

    public List<UsuarioDTO> listar() {
        List<Usuario> list = usuarioRepository.findAll();
        return list.stream().map(usuario ->
                new UsuarioDTO().fromUsuario(usuario)
        ).toList();
    }

    public UsuarioDTO crear(final CrearUsuarioDTO crearUsuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(crearUsuarioDTO.getUsername());
        usuario.setActivo(Boolean.TRUE);
        usuario.setPassword(passwordEncoder.encode(crearUsuarioDTO.getPassword()));
        usuario.setRoles(crearUsuarioDTO.getRoles());
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO().fromUsuario(usuario);
    }

}
