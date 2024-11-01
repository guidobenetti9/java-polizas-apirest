package com.TrabajoPolizas.Polizas.service;

import com.TrabajoPolizas.Polizas.model.TipoSeguro;
import com.TrabajoPolizas.Polizas.repository.TipoSeguroRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TipoSeguroService {
    @Autowired
    private TipoSeguroRepository tipoSeguroRepository;

    public List<TipoSeguro>findAll(){
        return tipoSeguroRepository.findAll();
    }

    public TipoSeguro findById(Long id) {
        return tipoSeguroRepository.findById(id).orElse(null);
    }
}
