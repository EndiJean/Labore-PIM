package com.unifcv.labore.controller;

import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.service.ClinicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unifcv/clinica")
@Api(value = "Labore+ API - Clinica")
@CrossOrigin(origins = "*")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Clínica por ID.")
    public Clinica findById(@PathVariable Integer id) {
        return clinicaService.procurarPorId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna uma Lista de Clínicas.")
    public List<Clinica> findAll() {
        return clinicaService.listar();
    }
    
    @GetMapping("/filter")
    @ApiOperation(value = "Retorna uma Lista de Clinica com filtro em nome.")
    public List<Clinica> findByLikeNome(@RequestParam("nome") String nome) {
        return clinicaService.ListarNomeLike(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva uma Clinica.")
    public Clinica SaveClinica(@RequestBody @Valid Clinica clinica) {
        return clinicaService.salvar(clinica);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza um Clinica por ID.")
    public void UpdateClinica(@PathVariable Integer id, @RequestBody Clinica clinica) {
        clinicaService.atualizar(id, clinica);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta uma Clinica por ID.")
    public void DeleteClinica(@PathVariable Integer id) {
        clinicaService.deletar(id);
    }

}
