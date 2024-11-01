package com.TrabajoPolizas.Polizas.service;


import com.TrabajoPolizas.Polizas.model.Cliente;
import com.TrabajoPolizas.Polizas.repository.ClienteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
