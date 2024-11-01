package com.TrabajoPolizas.Polizas.controller;

import com.TrabajoPolizas.Polizas.dtos.PolizaDTO;
import com.TrabajoPolizas.Polizas.exception.PolizaNotFoundException;
import com.TrabajoPolizas.Polizas.model.Cliente;
import com.TrabajoPolizas.Polizas.model.Poliza;
import com.TrabajoPolizas.Polizas.model.TipoSeguro;
import com.TrabajoPolizas.Polizas.service.ClienteService;
import com.TrabajoPolizas.Polizas.service.PolizaService;
import com.TrabajoPolizas.Polizas.service.TipoSeguroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(name = "api/poliza")
public class PolizaController {
    @Autowired
    private PolizaService polizaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TipoSeguroService tipoSeguroService;


    @GetMapping("/polizas")
    public ResponseEntity<List<PolizaDTO>> getAll() {
        return ResponseEntity.ok(polizaService.listarTodosDto());
    }

    @PostMapping("/polizas")
    public ResponseEntity<PolizaDTO> crearPoliza(@RequestBody PolizaDTO polizaDTO) {

        Poliza poliza = new Poliza();
        poliza.setNombreAsesor(polizaDTO.getNombreAsesor());
        poliza.setMatricula(polizaDTO.getMatricula());
        poliza.setObjetoAsegurado(polizaDTO.getObjetoAsegurado());
        poliza.setTipoCambio(polizaDTO.getTipoCambio());
        poliza.setFechaVencimiento(polizaDTO.getFechaVencimiento());
        poliza.setDeBaja(polizaDTO.getDeBaja());


        Cliente cliente = clienteService.findById(polizaDTO.getClienteId());
        poliza.setPolizaConCliente(cliente);

        TipoSeguro tipoSeguro = tipoSeguroService.findById(polizaDTO.getTipoSeguroId());
        poliza.setPolizaConTipo(tipoSeguro);


        Poliza responsePoliza = polizaService.save(poliza);

        PolizaDTO responsePolizaDTO = polizaService.convertToDTO(poliza);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePolizaDTO);
    }

    @PutMapping("/polizas/{id}")
    public ResponseEntity<Poliza> updatePoliza(@PathVariable("id")
                                                   @Min(value=0, message = "El valor debe ser mayor a cero")
                                                   Long id,
                                               @RequestBody @Valid Poliza poliza) throws PolizaNotFoundException
    {
        return ResponseEntity.ok(polizaService.update(poliza, id));

    }

    @DeleteMapping("/polizas/{id}")
    public  ResponseEntity<String>borrarPoliza(@PathVariable("id")
                                                   @Min(value=0, message = "El valor debe ser mayor a cero")
                                                   Long id) throws PolizaNotFoundException{
        polizaService.deleteById(id);
        return ResponseEntity.ok("poliza borrada");
    }

}
