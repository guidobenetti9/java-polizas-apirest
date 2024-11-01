package com.TrabajoPolizas.Polizas.controller;

import com.TrabajoPolizas.Polizas.dtos.CrearUsuarioDTO;
import com.TrabajoPolizas.Polizas.dtos.UsuarioDTO;
import com.TrabajoPolizas.Polizas.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody CrearUsuarioDTO crearUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crear(crearUsuarioDTO));
    }

}
