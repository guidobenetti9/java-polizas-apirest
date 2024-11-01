package com.TrabajoPolizas.Polizas.dtos;

import com.TrabajoPolizas.Polizas.model.Usuario;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UsuarioDTO {

    private Long id;
    private String username;
    private Boolean activo;
    private List<String> roles;

    public UsuarioDTO fromUsuario(final Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.activo = usuario.getActivo();
        this.roles = Arrays.asList(usuario.getRoles().split(","));
        return this;
    }
}
