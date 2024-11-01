package com.TrabajoPolizas.Polizas.service;

import com.TrabajoPolizas.Polizas.config.JwtService;
import com.TrabajoPolizas.Polizas.exception.PolizaException;
import com.TrabajoPolizas.Polizas.model.Usuario;
import com.TrabajoPolizas.Polizas.service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioService usuarioService;

    public Map<String, Object> login(final String username, final String password) {
        Map<String, Object> response = new HashMap<>();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Usuario usuario = usuarioService.getByUsername(username);
            response.put("id", usuario.getId());
            response.put("token", jwtService.generateToken(usuario.getId(), username, usuario.getRoles()));
        } catch (Exception e) {
            throw new PolizaException(HttpStatus.UNAUTHORIZED, "Credenciales invalidas....");
        }
        return response;
    }

}
