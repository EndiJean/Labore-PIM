package com.unifcv.labore.controller;

import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.repository.ClinicaRepository;
import com.unifcv.labore.service.ClinicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/unifcv/clinica")
@Api(value="Labore+ API")
@CrossOrigin(origins = "*")
public class ClinicaController {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private ClinicaService clinicaService;
    
    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um clinica por ID")
    public Clinica findById(@PathVariable Integer id){
        return clinicaService.ProcurarPorId(id);
    }  

    @GetMapping("/")
    @ApiOperation(value="Retorna uma lista de Clinicas")
    public List<Clinica> findAll(Clinica clinica) {
        return clinicaService.Listar(clinica);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Salva uma Clinica")
    public Clinica SalvarClinica(@RequestBody Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    
    //---------------------------------------------//
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Atualiza um Clinica por ID")
    public void UpdateClinica(@PathVariable Integer id, @RequestBody Clinica clinica) {
        clinicaRepository.findById(id).map(c -> {
            clinica.setId(c.getId());
            clinicaRepository.save(clinica);
            return c;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Deleta uma Clinica por ID")
    public void UpdateClinica(@PathVariable Integer id) {
        clinicaRepository.findById(id).map(clinica -> {
            clinicaRepository.delete(clinica);
            return clinicaRepository;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
