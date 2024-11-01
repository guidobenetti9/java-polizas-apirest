package com.TrabajoPolizas.Polizas.service;

import com.TrabajoPolizas.Polizas.dtos.PolizaDTO;
import com.TrabajoPolizas.Polizas.exception.PolizaNotFoundException;
import com.TrabajoPolizas.Polizas.model.Poliza;
import com.TrabajoPolizas.Polizas.repository.PolizaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class PolizaService {
    @Autowired
    private PolizaRepository polizaRepository;


    public List<Poliza> findAll() {
        return polizaRepository.findAll();
    }

    public List<PolizaDTO> listarTodosDto() {
        List<Poliza> polizas = polizaRepository.findAll();
        return polizas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PolizaDTO convertToDTO(Poliza poliza) {
        PolizaDTO responsePolizaDTO = new PolizaDTO();
        responsePolizaDTO.setId(poliza.getId());
        responsePolizaDTO.setNombreAsesor(poliza.getNombreAsesor());
        responsePolizaDTO.setMatricula(poliza.getMatricula());
        responsePolizaDTO.setObjetoAsegurado(poliza.getObjetoAsegurado());
        responsePolizaDTO.setTipoCambio(poliza.getTipoCambio());
        responsePolizaDTO.setFechaVencimiento(poliza.getFechaVencimiento());
        responsePolizaDTO.setDeBaja(poliza.getDeBaja());
        responsePolizaDTO.setClienteId(poliza.getPolizaConCliente().getId());
        responsePolizaDTO.setTipoSeguroId(poliza.getPolizaConTipo().getId());
        return responsePolizaDTO;
    }


    public Optional<Poliza> findById(Long id) {
        return polizaRepository.findById(id);
    }


    public Poliza save(Poliza poliza) {
        return polizaRepository.save(poliza);
    }


    public Poliza update(Poliza poliza, Long id) throws PolizaNotFoundException {
        Poliza buscarPoliza= this.findById(id).orElseThrow(()-> new PolizaNotFoundException(id));

        buscarPoliza.setObjetoAsegurado(poliza.getObjetoAsegurado());
        buscarPoliza.setFechaVencimiento(poliza.getFechaVencimiento());
        buscarPoliza.setNombreAsesor(poliza.getNombreAsesor());
        buscarPoliza.setMatricula(poliza.getMatricula());
        buscarPoliza.setDeBaja(poliza.getDeBaja());
        buscarPoliza.setTipoCambio(poliza.getTipoCambio());
        buscarPoliza.setPolizaConCliente(poliza.getPolizaConCliente());
        buscarPoliza.setPolizaConTipo(poliza.getPolizaConTipo());

        return polizaRepository.save(poliza);
    }


    public void deleteById(Long id) throws PolizaNotFoundException {
        Poliza poliza= this.findById(id).orElseThrow(()-> new PolizaNotFoundException(id));
        polizaRepository.deleteById(id);
    }


    public List<Poliza> findByNombreAsesor(String nombreAsesor) {
        return polizaRepository.findByNombreAsesor(nombreAsesor);
    }
}
