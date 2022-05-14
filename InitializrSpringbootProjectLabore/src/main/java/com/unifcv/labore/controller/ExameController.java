package com.unifcv.labore.controller;

import com.unifcv.labore.model.Exame;
import com.unifcv.labore.service.ExameService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/unifcv/exame")
@Api(value="Labore+ API - Exame")
@CrossOrigin(origins = "*")
public class ExameController {
    
    @Autowired
    ExameService exameService;
    
    @GetMapping("/id/{id}")
    @ApiOperation(value="Retorna um Exame por ID.")
    public Exame findById(@PathVariable Integer id){
        return exameService.procurarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Não Encontrado."));
    }
    
    @GetMapping("")
    @ApiOperation(value="Retorna uma Lista de Clínicas.")
    public List<Exame> findAll() {
        return exameService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Salva uma Clinica.")
    public Exame SaveClinica(@RequestBody @Valid Exame exame) {
        return exameService.salvar(exame);
    }
    
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Atualiza um Clinica por ID.")
    public void UpdateClinica(@PathVariable Integer id, @RequestBody @Valid Exame exame) {
        exameService.atualizar(id, exame);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Deleta uma Clinica por ID.")
    public void DeleteClinica(@PathVariable Integer id) {
       exameService.deletar(id);
    }
    
}
